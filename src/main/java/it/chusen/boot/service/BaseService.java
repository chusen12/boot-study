package it.chusen.boot.service;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import it.chusen.boot.model.result.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chusen
 */
@Slf4j
@Component
public class BaseService<T> {

    @Autowired
    protected JPAQueryFactory queryFactory;

    @Autowired
    protected JPAQueryFactory jpaQueryFactory;

    @Autowired
    @PersistenceContext
    protected EntityManager em;

    /**
     * 查询列表
     *
     * @param pageNo             分页参数(从0开始)
     * @param pageSize           分页大小
     * @param predicateList      查询条件
     * @param entityPathBase     查询表
     * @param orderSpecifierList 排序条件
     * @return
     */
    @Transactional(readOnly = true)
    public PageResult<T> queryDsl(Integer pageNo, Integer pageSize, List<Predicate> predicateList, EntityPathBase<T> entityPathBase, List<OrderSpecifier> orderSpecifierList) {
        List<T> list;
        //查询表
        JPAQuery<T> jpaQuery = jpaQueryFactory.selectFrom(entityPathBase);
        //查询条件
        if (predicateList != null && predicateList.size() > 0) {
            jpaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
        }
        //排序方式
        if (orderSpecifierList != null && orderSpecifierList.size() > 0) {
            jpaQuery.orderBy(orderSpecifierList.toArray(new OrderSpecifier[orderSpecifierList.size()]));
        }
        //分页查询
        boolean page = pageNo != null && pageSize != null && pageNo >= 0 && pageSize >= 1;
        if (page) {
            list = jpaQuery.offset(pageNo * pageSize).limit(pageSize).fetch();
            return new PageResult<T>(list, pageNo, pageSize, jpaQuery.fetchCount());
        } else {
            list = jpaQuery.fetch();
            long count = jpaQuery.fetchCount();
            return new PageResult<T>(list, 0, (int) count, count);
        }
    }

    /**
     * 查询单个
     *
     * @param predicate      查询条件
     * @param entityPathBase 查询表
     * @return
     */
    @Transactional(readOnly = true)
    public T queryOneDsl(Predicate predicate, EntityPathBase<T> entityPathBase) {
        return jpaQueryFactory.selectFrom(entityPathBase).where(predicate).fetchFirst();
    }

    //多表联合查询

    /**
     * @param qdc      queryDsl 查询对象
     * @param clazz
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Transactional(readOnly = true)
    public <U> PageResult queryDslForPageListResult(QueryDslContext qdc, Class<U> clazz, Integer pageNo, Integer pageSize) throws Exception {
        JPAQuery<Tuple> jpaQuery = queryFactory.select(qdc.expressionToArray())
                .from(qdc.entityPathToArray())
                .where(qdc.predicatesToArray());
        List<Tuple> tuples = jpaQuery.orderBy(qdc.orderSpecifiersToArray())
                .offset(pageNo * pageSize).limit(pageSize)
                .fetch();
        //返回结果

        List<U> list = new LinkedList<U>();
        //封装结果
        for (Tuple tuple : tuples) {
            U u = clazz.newInstance();
            for (Expression expression : qdc.getExpressions()) {
                //别名作为Key//获取结果
                String fieldName = expression.toString().split(" as ")[1];
                Field field = clazz.getDeclaredField(fieldName);
                if (field != null) {
                    field.setAccessible(true);
                    field.set(u, tuple.get(expression));
                }
            }
            list.add(u);
        }
        //分页封装
        return new PageResult<U>(list, pageNo, pageSize, jpaQuery.fetchCount());
    }

}