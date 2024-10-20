package org.eightbit.damdda.admin.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCarouselImage is a Querydsl query type for CarouselImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCarouselImage extends EntityPathBase<CarouselImage> {

    private static final long serialVersionUID = 264295559L;

    public static final QCarouselImage carouselImage = new QCarouselImage("carouselImage");

    public final StringPath adminImageUrl = createString("adminImageUrl");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QCarouselImage(String variable) {
        super(CarouselImage.class, forVariable(variable));
    }

    public QCarouselImage(Path<? extends CarouselImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarouselImage(PathMetadata metadata) {
        super(CarouselImage.class, metadata);
    }

}

