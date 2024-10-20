package org.eightbit.damdda.project.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCollaboration is a Querydsl query type for Collaboration
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCollaboration extends EntityPathBase<Collaboration> {

    private static final long serialVersionUID = -1753218137L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCollaboration collaboration = new QCollaboration("collaboration");

    public final StringPath approval = createString("approval");

    public final DateTimePath<java.util.Date> approvalDate = createDateTime("approvalDate", java.util.Date.class);

    public final StringPath collabDocList = createString("collabDocList");

    public final StringPath collaborationText = createString("collaborationText");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final QProject project;

    public final DatePath<java.time.LocalDate> receiverDeletedAt = createDate("receiverDeletedAt", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> savedAt = createDate("savedAt", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> senderDeletedAt = createDate("senderDeletedAt", java.time.LocalDate.class);

    public final StringPath userId = createString("userId");

    public QCollaboration(String variable) {
        this(Collaboration.class, forVariable(variable), INITS);
    }

    public QCollaboration(Path<? extends Collaboration> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCollaboration(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCollaboration(PathMetadata metadata, PathInits inits) {
        this(Collaboration.class, metadata, inits);
    }

    public QCollaboration(Class<? extends Collaboration> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}

