package org.eightbit.damdda.order.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDelivery is a Querydsl query type for Delivery
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDelivery extends EntityPathBase<Delivery> {

    private static final long serialVersionUID = -2085591609L;

    public static final QDelivery delivery = new QDelivery("delivery");

    public final StringPath deliveryAddress = createString("deliveryAddress");

    public final StringPath deliveryDetailedAddress = createString("deliveryDetailedAddress");

    public final StringPath deliveryEmail = createString("deliveryEmail");

    public final NumberPath<Long> deliveryId = createNumber("deliveryId", Long.class);

    public final StringPath deliveryMessage = createString("deliveryMessage");

    public final StringPath deliveryName = createString("deliveryName");

    public final StringPath deliveryPhoneNumber = createString("deliveryPhoneNumber");

    public final NumberPath<Integer> deliveryPostCode = createNumber("deliveryPostCode", Integer.class);

    public QDelivery(String variable) {
        super(Delivery.class, forVariable(variable));
    }

    public QDelivery(Path<? extends Delivery> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDelivery(PathMetadata metadata) {
        super(Delivery.class, metadata);
    }

}

