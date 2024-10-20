package org.eightbit.damdda.project.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProjectImageType is a Querydsl query type for ProjectImageType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProjectImageType extends EntityPathBase<ProjectImageType> {

    private static final long serialVersionUID = 743615354L;

    public static final QProjectImageType projectImageType = new QProjectImageType("projectImageType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageType = createString("imageType");

    public QProjectImageType(String variable) {
        super(ProjectImageType.class, forVariable(variable));
    }

    public QProjectImageType(Path<? extends ProjectImageType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProjectImageType(PathMetadata metadata) {
        super(ProjectImageType.class, metadata);
    }

}

