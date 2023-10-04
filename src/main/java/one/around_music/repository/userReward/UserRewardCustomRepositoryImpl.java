package one.around_music.repository.userReward;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import one.around_music.domain.QUserReward;
import one.around_music.domain.UserReward;
import one.around_music.enums.RewardType;
import one.around_music.vo.UserRewardVo;

import java.util.Optional;

@RequiredArgsConstructor
public class UserRewardCustomRepositoryImpl implements UserRewardCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public UserRewardVo findReward(Long userId, RewardType rewardType) {
        QUserReward ur = QUserReward.userReward;
        return queryFactory.select(
                        Projections.constructor(
                                UserRewardVo.class,
                                ur.reward.id,
                                ur.reward.reward
                        )
                ).from(ur)
                .where(ur.user.id.eq(userId))
                .where(ur.reward.rewardType.eq(rewardType))
                .fetchOne();
    }

    @Override
    public Long findUserReward(Long userId, RewardType rewardType) {
        QUserReward ur = QUserReward.userReward;
        return queryFactory.select(
                        ur.id
                ).from(ur)
                .where(ur.user.id.eq(userId))
                .where(ur.reward.rewardType.eq(rewardType))
                .fetchOne();
    }
}
