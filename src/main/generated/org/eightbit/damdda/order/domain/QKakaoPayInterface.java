package org.eightbit.damdda.order.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QKakaoPayInterface is a Querydsl query type for KakaoPayInterface
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKakaoPayInterface extends EntityPathBase<KakaoPayInterface> {

    private static final long serialVersionUID = 1370226017L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QKakaoPayInterface kakaoPayInterface = new QKakaoPayInterface("kakaoPayInterface");

    public final NumberPath<Long> kakaopayInterfaceId = createNumber("kakaopayInterfaceId", Long.class);

    public final QPayment payment;

    public QKakaoPayInterface(String variable) {
        this(KakaoPayInterface.class, forVariable(variable), INITS);
    }

    public QKakaoPayInterface(Path<? extends KakaoPayInterface> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QKakaoPayInterface(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QKakaoPayInterface(PathMetadata metadata, PathInits inits) {
        this(KakaoPayInterface.class, metadata, inits);
    }

    public QKakaoPayInterface(Class<? extends KakaoPayInterface> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.payment = inits.isInitialized("payment") ? new QPayment(forProperty("payment")) : null;
    }

}

