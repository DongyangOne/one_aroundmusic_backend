package one.around_music.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import one.around_music.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_userReward")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserReward extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reward_id")
    private Reward reward;


}
