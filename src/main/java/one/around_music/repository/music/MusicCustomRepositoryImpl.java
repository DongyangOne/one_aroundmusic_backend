package one.around_music.repository.music;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import one.around_music.domain.QMusic;
import one.around_music.vo.MusicVo;

import java.util.List;

@RequiredArgsConstructor
public class MusicCustomRepositoryImpl implements MusicCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MusicVo> findAllMusic() {
        QMusic m = QMusic.music;
        return queryFactory.select(
                Projections.constructor(
                        MusicVo.class,
                        m.id,
                        m.youtubId,
                        m.title,
                        m.thumbnail
                )
        ).from(m)
                .fetch();
    }

}
