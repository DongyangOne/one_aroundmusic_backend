package one.around_music.repository.friend;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import one.around_music.domain.QFriend;
import one.around_music.domain.QUser;
import one.around_music.vo.FriendVo;
import one.around_music.vo.UserVo;

import java.util.List;

@RequiredArgsConstructor
public class FriendCustomRepositoryImpl implements FriendCustomRepository {

    private final JPAQueryFactory queryFactory;

    public List<FriendVo> findReciveInviteList(Long userId) {
        QFriend f  = QFriend.friend1;
        List<FriendVo> list = queryFactory.select(
                        Projections.constructor(
                                FriendVo.class,
                                f.id,
                                f.user.id,
                                f.user.nickname,
                                f.user.profileImg
                        )
                ).from(f)
                .where(f.status.eq("N"))
                .where(f.friend.id.eq(userId)).fetch();

        return list;
    }

    public List<FriendVo> findSendInviteList(Long userId) {
        QFriend f  = QFriend.friend1;
        List<FriendVo> list = queryFactory.select(
                        Projections.constructor(
                                FriendVo.class,
                                f.id,
                                f.friend.id,
                                f.friend.nickname,
                                f.friend.profileImg
                        )
                ).from(f)
                .where(f.status.eq("Y"))
                .where((f.user.id.eq(userId))).fetch();

        return list;
    }

    public List<FriendVo> findFriendList(Long userId) {
        QFriend f  = QFriend.friend1;
        List<FriendVo> list = queryFactory.select(
                        Projections.constructor(
                                FriendVo.class,
                                f.id,
                                f.friend.id,
                                f.friend.nickname,
                                f.friend.profileImg
                        )
                ).from(f)
                .where(f.status.eq("Y"))
                .where((f.user.id.eq(userId))).fetch();

        List<FriendVo> list2 = queryFactory.select(
                        Projections.constructor(
                                FriendVo.class,
                                f.id,
                                f.user.id,
                                f.user.nickname,
                                f.user.profileImg
                        )
                ).from(f)
                .where(f.status.eq("Y"))
                .where(f.friend.id.eq(userId)).fetch();

        list.addAll(list2);

        return list;
    }

    // 나와 관련된 어떠한 친구 관계도 없는 (tbl_friend에 나와 관련된 유저 전체 제외)유저 조회
    @Override
    public List<UserVo> findAllUserExceptFriend(Long user_id) {
        QUser u = QUser.user;
        QFriend f = QFriend.friend1;
        return queryFactory.select(
                Projections.constructor(
                        UserVo.class,
                        u.id,
                        u.nickname,
                        u.profileImg
                )
        ).from(u)
                .where(u.id.notIn(
                        JPAExpressions.select(u.id)
                                .from(u)
                                .leftJoin(f)
                                .on(u.id.eq(f.user.id).or(u.id.eq(f.friend.id)))
                                .where(f.user.id.eq(user_id).or(f.friend.id.eq(user_id)))
                ))
                .fetch();
    }
}
