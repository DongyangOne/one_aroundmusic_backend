package one.around_music.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMarker is a Querydsl query type for Marker
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMarker extends EntityPathBase<Marker> {

    private static final long serialVersionUID = 961421265L;

    public static final QMarker marker = new QMarker("marker");

    public final one.around_music.common.entity.QBaseEntity _super = new one.around_music.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public QMarker(String variable) {
        super(Marker.class, forVariable(variable));
    }

    public QMarker(Path<? extends Marker> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMarker(PathMetadata metadata) {
        super(Marker.class, metadata);
    }

}

