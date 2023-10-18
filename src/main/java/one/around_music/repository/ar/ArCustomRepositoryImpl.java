package one.around_music.repository.ar;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import one.around_music.domain.QAr;
import one.around_music.domain.QUserReward;
import one.around_music.enums.RewardType;
import one.around_music.vo.ArVo;
import one.around_music.vo.MusicVo;

import java.util.List;
@RequiredArgsConstructor
public class ArCustomRepositoryImpl implements ArCustomRepository {
    private final JPAQueryFactory queryFactory;
    @Override
    public List<ArVo> findArList() {
        QAr ar = QAr.ar;
        QUserReward ur = QUserReward.userReward;
        return queryFactory.select(
                Projections.constructor(
                        ArVo.class,
                        ar.id,
                        Projections.constructor(
                                MusicVo.class,
                                ar.id,
                                ar.music.youtubId,
                                ar.music.title,
                                ar.music.thumbnail
                        ),
                        ur.reward.reward,
                        ar.latitude,
                        ar.longitude
                )
        ).from(ar)
                .leftJoin(ur)
                .on(ar.user.eq(ur.user))
                .where(ur.reward.rewardType.eq(RewardType.POPULARITY))
                .orderBy(ar.id.desc())
                .fetch().subList(0, 10);
    }
}
