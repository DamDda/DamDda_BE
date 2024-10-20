package org.eightbit.damdda.noticeandqna.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQnaQuestion is a Querydsl query type for QnaQuestion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQnaQuestion extends EntityPathBase<QnaQuestion> {

    private static final long serialVersionUID = -169069102L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQnaQuestion qnaQuestion = new QQnaQuestion("qnaQuestion");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> deletedAt = createDateTime("deletedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final org.eightbit.damdda.member.domain.QMember member;

    public final org.eightbit.damdda.project.domain.QProject project;

    public final StringPath title = createString("title");

    public final EnumPath<QnaQuestion.Visibility> visibility = createEnum("visibility", QnaQuestion.Visibility.class);

    public QQnaQuestion(String variable) {
        this(QnaQuestion.class, forVariable(variable), INITS);
    }

    public QQnaQuestion(Path<? extends QnaQuestion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQnaQuestion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQnaQuestion(PathMetadata metadata, PathInits inits) {
        this(QnaQuestion.class, metadata, inits);
    }

    public QQnaQuestion(Class<? extends QnaQuestion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new org.eightbit.damdda.member.domain.QMember(forProperty("member")) : null;
        this.project = inits.isInitialized("project") ? new org.eightbit.damdda.project.domain.QProject(forProperty("project"), inits.get("project")) : null;
    }

}

