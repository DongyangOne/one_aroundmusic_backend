package one.around_music.repository.story;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import one.around_music.domain.QFriend;
import one.around_music.domain.QStory;
import one.around_music.domain.QUser;
import one.around_music.vo.MusicVo;
import one.around_music.vo.UserVo;

import java.util.List;

@RequiredArgsConstructor
public class StoryCustomRepositoryImpl implements StoryCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MusicVo> findAllStory(Long userId) {
        QStory s = QStory.story;
        return queryFactory.select(
                Projections.constructor(
                        MusicVo.class,
                        s.music.id,
                        s.music.youtubId,
                        s.music.title,
                        s.music.thumbnail
                )
        ).from(s)
                .where(s.user.id.eq(userId))
                .fetch();
    }

    @Override
    public List<UserVo> findStoryUser(Long userId) {
        QStory s = QStory.story;
        QUser u = QUser.user;
        QFriend f = QFriend.friend1;

        return queryFactory.select(
                Projections.constructor(
                        UserVo.class,
                        s.user.id,
                        s.user.nickname,
                        s.user.profileImg
                )
        ).from(s)
                .where(s.user.id.in(
                        JPAExpressions.select(u.id)
                                .from(u)
                                .innerJoin(f)
                                .on(f.user.id.eq(u.id).or(f.friend.id.eq(u.id)))
                                .where(f.user.id.eq(userId).or(f.friend.id.eq(userId)).and(f.status.eq("Y")))
                ).and(s.user.id.ne(userId)))
                .distinct()
                .fetch();
    }

}
