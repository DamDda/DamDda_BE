package org.eightbit.damdda.project.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProjectRewards is a Querydsl query type for ProjectRewards
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProjectRewards extends EntityPathBase<ProjectRewards> {

    private static final long serialVersionUID = 1620773033L;

    public static final QProjectRewards projectRewards = new QProjectRewards("projectRewards");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath optionList = createString("optionList");

    public final StringPath optionType = createString("optionType");

    public final ListPath<PackageRewards, QPackageRewards> packageRewards = this.<PackageRewards, QPackageRewards>createList("packageRewards", PackageRewards.class, QPackageRewards.class, PathInits.DIRECT2);

    public final StringPath rewardName = createString("rewardName");

    public QProjectRewards(String variable) {
        super(ProjectRewards.class, forVariable(variable));
    }

    public QProjectRewards(Path<? extends ProjectRewards> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProjectRewards(PathMetadata metadata) {
        super(ProjectRewards.class, metadata);
    }

}

