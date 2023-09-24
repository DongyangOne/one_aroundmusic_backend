package one.around_music.repository.friend;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import one.around_music.domain.QFriend;
import one.around_music.vo.FriendVo;

import java.util.List;

@RequiredArgsConstructor
public class FriendCustomRepositoryImpl implements FriendCustomRepository {

    private final JPAQueryFactory queryFactory;

    public List<FriendVo> findInviteList(Long userId) {
        QFriend f  = QFriend.friend1;
        List<FriendVo> list = queryFactory.select(
                Projections.constructor(
                        FriendVo.class,
                        f.id,
                        f.friend.id,
                        f.friend.profileImg,
                        f.friend.nickname
                )
        ).from(f)
                .orderBy(f.createdDate.desc())
                .leftJoin(QFriend.friend1.friend)
                .where(f.status.eq("N"))
                .where(f.friend.id.eq(userId)).fetch();
        return list;
    }

    public List<FriendVo> findFriendList(Long userId) {
        QFriend f  = QFriend.friend1;
        List<FriendVo> list = queryFactory.select(
                        Projections.constructor(
                                FriendVo.class,
                                f.id,
                                f.friend.id,
                                f.friend.profileImg,
                                f.friend.nickname
                        )
                ).from(f)
                .orderBy(f.createdDate.desc())
                .leftJoin(QFriend.friend1.friend)
                .where(f.status.eq("Y"))
                .where(f.friend.id.eq(userId).or(f.id.eq(userId))).fetch();
        return list;
    }

}
