package one.around_music.repository.story;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import one.around_music.domain.QStory;
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
    public List<UserVo> findStoryUser() {
        QStory s = QStory.story;
        return queryFactory.select(
                Projections.constructor(
                        UserVo.class,
                        s.user.id,
                        s.user.nickname,
                        s.user.profileImg
                )
        ).from(s)
                .groupBy(s.user)
                .fetch();
    }

}
