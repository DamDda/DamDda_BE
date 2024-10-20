package org.eightbit.damdda.project.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProjectDocument is a Querydsl query type for ProjectDocument
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProjectDocument extends EntityPathBase<ProjectDocument> {

    private static final long serialVersionUID = -194342858L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProjectDocument projectDocument = new QProjectDocument("projectDocument");

    public final StringPath fileName = createString("fileName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> ord = createNumber("ord", Integer.class);

    public final QProject project;

    public final StringPath url = createString("url");

    public QProjectDocument(String variable) {
        this(ProjectDocument.class, forVariable(variable), INITS);
    }

    public QProjectDocument(Path<? extends ProjectDocument> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProjectDocument(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProjectDocument(PathMetadata metadata, PathInits inits) {
        this(ProjectDocument.class, metadata, inits);
    }

    public QProjectDocument(Class<? extends ProjectDocument> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}

