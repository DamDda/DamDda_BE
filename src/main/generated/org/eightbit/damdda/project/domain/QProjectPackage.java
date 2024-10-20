package org.eightbit.damdda.project.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProjectPackage is a Querydsl query type for ProjectPackage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProjectPackage extends EntityPathBase<ProjectPackage> {

    private static final long serialVersionUID = -286939701L;

    public static final QProjectPackage projectPackage = new QProjectPackage("projectPackage");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath packageName = createString("packageName");

    public final NumberPath<Integer> packagePrice = createNumber("packagePrice", Integer.class);

    public final ListPath<PackageRewards, QPackageRewards> packageRewards = this.<PackageRewards, QPackageRewards>createList("packageRewards", PackageRewards.class, QPackageRewards.class, PathInits.DIRECT2);

    public final NumberPath<Integer> quantityLimited = createNumber("quantityLimited", Integer.class);

    public final NumberPath<Integer> salesQuantity = createNumber("salesQuantity", Integer.class);

    public QProjectPackage(String variable) {
        super(ProjectPackage.class, forVariable(variable));
    }

    public QProjectPackage(Path<? extends ProjectPackage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProjectPackage(PathMetadata metadata) {
        super(ProjectPackage.class, metadata);
    }

}

