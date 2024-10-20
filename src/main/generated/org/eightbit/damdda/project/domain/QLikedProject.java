package org.eightbit.damdda.project.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLikedProject is a Querydsl query type for LikedProject
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLikedProject extends EntityPathBase<LikedProject> {

    private static final long serialVersionUID = -613690102L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLikedProject likedProject = new QLikedProject("likedProject");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> likedAt = createDateTime("likedAt", java.time.LocalDateTime.class);

    public final org.eightbit.damdda.member.domain.QMember member;

    public final QProject project;

    public QLikedProject(String variable) {
        this(LikedProject.class, forVariable(variable), INITS);
    }

    public QLikedProject(Path<? extends LikedProject> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLikedProject(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLikedProject(PathMetadata metadata, PathInits inits) {
        this(LikedProject.class, metadata, inits);
    }

    public QLikedProject(Class<? extends LikedProject> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new org.eightbit.damdda.member.domain.QMember(forProperty("member")) : null;
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}

