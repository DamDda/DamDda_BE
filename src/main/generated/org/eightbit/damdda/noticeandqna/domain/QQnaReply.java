package org.eightbit.damdda.noticeandqna.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQnaReply is a Querydsl query type for QnaReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQnaReply extends EntityPathBase<QnaReply> {

    private static final long serialVersionUID = -1392230274L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQnaReply qnaReply = new QQnaReply("qnaReply");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> deletedAt = createDateTime("deletedAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> depth = createNumber("depth", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final org.eightbit.damdda.member.domain.QMember member;

    public final NumberPath<Integer> orderPosition = createNumber("orderPosition", Integer.class);

    public final QQnaReply parentReply;

    public final QQnaQuestion qnaQuestion;

    public QQnaReply(String variable) {
        this(QnaReply.class, forVariable(variable), INITS);
    }

    public QQnaReply(Path<? extends QnaReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQnaReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQnaReply(PathMetadata metadata, PathInits inits) {
        this(QnaReply.class, metadata, inits);
    }

    public QQnaReply(Class<? extends QnaReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new org.eightbit.damdda.member.domain.QMember(forProperty("member")) : null;
        this.parentReply = inits.isInitialized("parentReply") ? new QQnaReply(forProperty("parentReply"), inits.get("parentReply")) : null;
        this.qnaQuestion = inits.isInitialized("qnaQuestion") ? new QQnaQuestion(forProperty("qnaQuestion"), inits.get("qnaQuestion")) : null;
    }

}

