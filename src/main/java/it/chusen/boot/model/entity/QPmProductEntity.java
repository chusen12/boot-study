package it.chusen.boot.model.entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QPmProductEntity is a Querydsl query type for PmProductEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPmProductEntity extends EntityPathBase<PmProductEntity> {

    private static final long serialVersionUID = 1660645900L;

    public static final QPmProductEntity pmProductEntity = new QPmProductEntity("pmProductEntity");

    public final NumberPath<Long> brandId = createNumber("brandId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath model = createString("model");

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final StringPath prodName = createString("prodName");

    public QPmProductEntity(String variable) {
        super(PmProductEntity.class, forVariable(variable));
    }

    public QPmProductEntity(Path<? extends PmProductEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPmProductEntity(PathMetadata metadata) {
        super(PmProductEntity.class, metadata);
    }

}

