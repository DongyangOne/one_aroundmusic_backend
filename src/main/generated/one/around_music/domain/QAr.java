package one.around_music.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAr is a Querydsl query type for Ar
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAr extends EntityPathBase<Ar> {

    private static final long serialVersionUID = 1988950856L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAr ar = new QAr("ar");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final QMarker marker;

    public final QMusic music;

    public final QUser user;

    public QAr(String variable) {
        this(Ar.class, forVariable(variable), INITS);
    }

    public QAr(Path<? extends Ar> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAr(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAr(PathMetadata metadata, PathInits inits) {
        this(Ar.class, metadata, inits);
    }

    public QAr(Class<? extends Ar> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.marker = inits.isInitialized("marker") ? new QMarker(forProperty("marker")) : null;
        this.music = inits.isInitialized("music") ? new QMusic(forProperty("music")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

