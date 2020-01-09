package it.chusen.boot.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author bairenjie
 * @date 2019/10/16 14:24
 */
@Configuration
public class JpaQueryFactory {
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Bean("jpaFactory")
    public JPAQueryFactory jpaQueryFactory(){
        return new JPAQueryFactory(entityManager);
    }
}
