package org.eightbit.damdda.admin.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAdminApproval is a Querydsl query type for AdminApproval
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminApproval extends EntityPathBase<AdminApproval> {

    private static final long serialVersionUID = -1631539362L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAdminApproval adminApproval = new QAdminApproval("adminApproval");

    public final NumberPath<Integer> approval = createNumber("approval", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> approvalAt = createDateTime("approvalAt", java.time.LocalDateTime.class);

    public final StringPath approvalText = createString("approvalText");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final org.eightbit.damdda.project.domain.QProject project;

    public QAdminApproval(String variable) {
        this(AdminApproval.class, forVariable(variable), INITS);
    }

    public QAdminApproval(Path<? extends AdminApproval> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAdminApproval(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAdminApproval(PathMetadata metadata, PathInits inits) {
        this(AdminApproval.class, metadata, inits);
    }

    public QAdminApproval(Class<? extends AdminApproval> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.project = inits.isInitialized("project") ? new org.eightbit.damdda.project.domain.QProject(forProperty("project"), inits.get("project")) : null;
    }

}

