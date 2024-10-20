package org.eightbit.damdda.order.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSupportingPackage is a Querydsl query type for SupportingPackage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSupportingPackage extends EntityPathBase<SupportingPackage> {

    private static final long serialVersionUID = 1616465568L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSupportingPackage supportingPackage = new QSupportingPackage("supportingPackage");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath OptionList = createString("OptionList");

    public final QOrder order;

    public final NumberPath<Integer> packageCount = createNumber("packageCount", Integer.class);

    public final org.eightbit.damdda.project.domain.QProjectPackage projectPackage;

    public final QSupportingProject supportingProject;

    public QSupportingPackage(String variable) {
        this(SupportingPackage.class, forVariable(variable), INITS);
    }

    public QSupportingPackage(Path<? extends SupportingPackage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSupportingPackage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSupportingPackage(PathMetadata metadata, PathInits inits) {
        this(SupportingPackage.class, metadata, inits);
    }

    public QSupportingPackage(Class<? extends SupportingPackage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.order = inits.isInitialized("order") ? new QOrder(forProperty("order"), inits.get("order")) : null;
        this.projectPackage = inits.isInitialized("projectPackage") ? new org.eightbit.damdda.project.domain.QProjectPackage(forProperty("projectPackage")) : null;
        this.supportingProject = inits.isInitialized("supportingProject") ? new QSupportingProject(forProperty("supportingProject"), inits.get("supportingProject")) : null;
    }

}

