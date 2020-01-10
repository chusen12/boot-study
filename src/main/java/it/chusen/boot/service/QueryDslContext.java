package it.chusen.boot.service;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

import java.util.*;

/**
 * @author chusen
 */
public class QueryDslContext {

    private List<Expression> expressions;
    private List<EntityPath> entityPaths;
    private List<Predicate> predicates;
    private List<OrderSpecifier> orderSpecifiers;
    public static final String INNER = "inner";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String FIRST = "first";
    private EntityPath lastTable;
    private LinkedHashMap<EntityPath, String> tables = new LinkedHashMap<>();

    public QueryDslContext() {
        this.expressions = new ArrayList<>();
        this.entityPaths = new ArrayList<>();
        this.predicates = new ArrayList<>();
        this.orderSpecifiers = new ArrayList<>();
    }

    public QueryDslContext table(EntityPath entityPath) {
        tables.put(entityPath, FIRST);
        return this;
    }

    public LinkedHashMap<EntityPath, String> getTables() {
        return this.tables;
    }

    public QueryDslContext innerJoin(EntityPath entityPath) {
        tables.put(entityPath, INNER);
        lastTable = entityPath;
        return this;
    }

    public QueryDslContext leftJoin(EntityPath entityPath) {
        tables.put(entityPath, LEFT);
        lastTable = entityPath;
        return this;
    }

    public QueryDslContext rightJoin(EntityPath<Object> entityPath) {
        tables.put(entityPath, RIGHT);
        lastTable = entityPath;
        return this;
    }


    public List<Expression> getExpressions() {
        return expressions;
    }

    public void add(Expression expression) {
        expressions.add(expression);
    }

    public void add(EntityPath entityPath) {
        entityPaths.add(entityPath);
    }

    public void add(Predicate predicate) {
        predicates.add(predicate);
    }

    public void add(OrderSpecifier orderSpecifier) {
        orderSpecifiers.add(orderSpecifier);
    }

    public Expression[] expressionToArray() {
        return expressions.toArray(new Expression[expressions.size()]);
    }

    public EntityPath[] entityPathToArray() {
        return entityPaths.toArray(new EntityPath[entityPaths.size()]);
    }

    public Predicate[] predicatesToArray() {
        return predicates.toArray(new Predicate[predicates.size()]);
    }

    public OrderSpecifier[] orderSpecifiersToArray() {
        return orderSpecifiers.toArray(new OrderSpecifier[orderSpecifiers.size()]);
    }

    private Map<EntityPath, List<Predicate>> on = new LinkedHashMap<>();

    public QueryDslContext on(Predicate... predicates) {
        if (lastTable == null) {
            throw new RuntimeException("one table can't on! ");
        }
        List<Predicate> lists = new ArrayList<>(Arrays.asList(predicates));
        on.put(lastTable, lists);
        return this;
    }

    public Map<EntityPath, List<Predicate>> getOn() {
        return this.on;
    }

}