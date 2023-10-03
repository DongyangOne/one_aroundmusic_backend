package one.around_music.repository.reward;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import one.around_music.domain.QReward;
import one.around_music.enums.RewardType;
import one.around_music.vo.RewardVo;

import java.util.List;

@RequiredArgsConstructor
public class RewardCustomRepositoryImpl implements RewardCustomRepository{
    private final JPAQueryFactory queryFactory;
    @Override
    public List<RewardVo> findAllByRewardType(RewardType rewardType) {
        QReward r = QReward.reward1;
        return queryFactory.select(
                Projections.constructor(
                        RewardVo.class,
                        r.id,
                        r.reward
                )
        ).from(r)
                .where(r.rewardType.eq(rewardType)).fetch();
    }

}
