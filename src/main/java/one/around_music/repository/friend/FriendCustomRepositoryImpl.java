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
//                .leftJoin(f)
//                .on(f.user.id.eq(u.id).or(f.friend.id.eq(u.id)))
//                .where(f.status.isNull().or(f.user.id.ne(user_id).and(f.friend.id.ne(user_id))))
                .fetch();
    }
}
