package org.eightbit.damdda.order.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSupportingProject is a Querydsl query type for SupportingProject
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSupportingProject extends EntityPathBase<SupportingProject> {

    private static final long serialVersionUID = 2114217331L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSupportingProject supportingProject = new QSupportingProject("supportingProject");

    public final QDelivery delivery;

    public final QPayment payment;

    public final org.eightbit.damdda.project.domain.QProject project;

    public final DateTimePath<java.time.LocalDateTime> supportedAt = createDateTime("supportedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> supportingProjectId = createNumber("supportingProjectId", Long.class);

    public final org.eightbit.damdda.member.domain.QMember user;

    public QSupportingProject(String variable) {
        this(SupportingProject.class, forVariable(variable), INITS);
    }

    public QSupportingProject(Path<? extends SupportingProject> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSupportingProject(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSupportingProject(PathMetadata metadata, PathInits inits) {
        this(SupportingProject.class, metadata, inits);
    }

    public QSupportingProject(Class<? extends SupportingProject> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.delivery = inits.isInitialized("delivery") ? new QDelivery(forProperty("delivery")) : null;
        this.payment = inits.isInitialized("payment") ? new QPayment(forProperty("payment")) : null;
        this.project = inits.isInitialized("project") ? new org.eightbit.damdda.project.domain.QProject(forProperty("project"), inits.get("project")) : null;
        this.user = inits.isInitialized("user") ? new org.eightbit.damdda.member.domain.QMember(forProperty("user")) : null;
    }

}

