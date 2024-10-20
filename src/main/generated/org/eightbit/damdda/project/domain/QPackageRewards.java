package org.eightbit.damdda.project.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPackageRewards is a Querydsl query type for PackageRewards
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPackageRewards extends EntityPathBase<PackageRewards> {

    private static final long serialVersionUID = 741532380L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPackageRewards packageRewards = new QPackageRewards("packageRewards");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProject project;

    public final QProjectPackage projectPackage;

    public final QProjectRewards projectReward;

    public final NumberPath<Integer> rewardCount = createNumber("rewardCount", Integer.class);

    public QPackageRewards(String variable) {
        this(PackageRewards.class, forVariable(variable), INITS);
    }

    public QPackageRewards(Path<? extends PackageRewards> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPackageRewards(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPackageRewards(PathMetadata metadata, PathInits inits) {
        this(PackageRewards.class, metadata, inits);
    }

    public QPackageRewards(Class<? extends PackageRewards> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
        this.projectPackage = inits.isInitialized("projectPackage") ? new QProjectPackage(forProperty("projectPackage")) : null;
        this.projectReward = inits.isInitialized("projectReward") ? new QProjectRewards(forProperty("projectReward")) : null;
    }

}

