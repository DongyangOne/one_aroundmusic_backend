package one.around_music.repository.ar;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import one.around_music.domain.QAr;
import one.around_music.domain.QUserReward;
import one.around_music.enums.RewardType;
import one.around_music.vo.ArVo;

import java.util.List;
@RequiredArgsConstructor
public class ArCustomRepositoryImpl implements ArCustomRepository {
    private final JPAQueryFactory queryFactory;
    @Override
    public List<ArVo> findArList(Long markerId) {
        QAr ar = QAr.ar;
        QUserReward ur = QUserReward.userReward;
        return queryFactory.select(
                Projections.constructor(
                        ArVo.class,
                        ar.id,
                        ar.music,
                        ur.reward.reward,
                        ar.latitude,
                        ar.longitude
                )
        ).from(ar)
                .leftJoin(ur)
                .on(ar.user.eq(ur.user))
                .where(ar.marker.id.eq(markerId))
                .where(ur.reward.rewardType.eq(RewardType.POPULARITY))
                .fetch();
    }
}
