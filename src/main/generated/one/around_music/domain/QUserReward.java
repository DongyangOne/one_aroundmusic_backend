package one.around_music.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserReward is a Querydsl query type for UserReward
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserReward extends EntityPathBase<UserReward> {

    private static final long serialVersionUID = -1129067791L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserReward userReward = new QUserReward("userReward");

    public final one.around_music.common.entity.QBaseEntity _super = new one.around_music.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QReward reward;

    public final QUser user;

    public QUserReward(String variable) {
        this(UserReward.class, forVariable(variable), INITS);
    }

    public QUserReward(Path<? extends UserReward> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserReward(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserReward(PathMetadata metadata, PathInits inits) {
        this(UserReward.class, metadata, inits);
    }

    public QUserReward(Class<? extends UserReward> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reward = inits.isInitialized("reward") ? new QReward(forProperty("reward")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

