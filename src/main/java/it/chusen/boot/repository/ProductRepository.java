package it.chusen.boot.repository;

import it.chusen.boot.model.entity.PmProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author chusen
 * @date 2020/1/9 2:58 下午
 */
public interface ProductRepository extends
        JpaRepository<PmProductEntity, Long>,
        QuerydslPredicateExecutor<PmProductEntity> {
}
