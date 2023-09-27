package one.around_music.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReward is a Querydsl query type for Reward
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReward extends EntityPathBase<Reward> {

    private static final long serialVersionUID = 1108400838L;

    public static final QReward reward1 = new QReward("reward1");

    public final one.around_music.common.entity.QBaseEntity _super = new one.around_music.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath reward = createString("reward");

    public final EnumPath<one.around_music.enums.RewardType> rewardType = createEnum("rewardType", one.around_music.enums.RewardType.class);

    public QReward(String variable) {
        super(Reward.class, forVariable(variable));
    }

    public QReward(Path<? extends Reward> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReward(PathMetadata metadata) {
        super(Reward.class, metadata);
    }

}

