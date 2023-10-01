package one.around_music.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import one.around_music.common.entity.BaseEntity;
import one.around_music.enums.RewardType;

import javax.persistence.*;

@Entity
@Table(name = "tbl_reward")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reward extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reward_type", nullable = false)
    private RewardType rewardType;

    @Column(name = "reward", length = 120)
    private String reward;

}
