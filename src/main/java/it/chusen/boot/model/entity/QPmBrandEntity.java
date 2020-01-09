package it.chusen.boot.model.entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QPmBrandEntity is a Querydsl query type for PmBrandEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPmBrandEntity extends EntityPathBase<PmBrandEntity> {

    private static final long serialVersionUID = 2005789988L;

    public static final QPmBrandEntity pmBrandEntity = new QPmBrandEntity("pmBrandEntity");

    public final StringPath brandName = createString("brandName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QPmBrandEntity(String variable) {
        super(PmBrandEntity.class, forVariable(variable));
    }

    public QPmBrandEntity(Path<? extends PmBrandEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPmBrandEntity(PathMetadata metadata) {
        super(PmBrandEntity.class, metadata);
    }

}

