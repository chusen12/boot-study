package it.chusen.test;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import it.chusen.boot.BootApplication;
import it.chusen.boot.model.entity.PmBrandEntity;
import it.chusen.boot.model.entity.PmProductEntity;
import it.chusen.boot.model.entity.QPmBrandEntity;
import it.chusen.boot.model.entity.QPmProductEntity;
import it.chusen.boot.model.result.PageListMapResult;
import it.chusen.boot.model.result.PageResult;
import it.chusen.boot.model.vo.ProductVO;
import it.chusen.boot.repository.ProductRepository;
import it.chusen.boot.service.ProductService;
import it.chusen.boot.service.QueryDslContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chusen
 * @date 2020/1/7 9:30 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class MyTest {

    @Resource(name = "jpaFactory")
    private JPAQueryFactory jpaFactory;

    @Resource
    private ProductRepository productRepository;

    @Resource
    private ProductService productService;


    @Test
    public void testLike() {
        QPmProductEntity qPmProductEntity = QPmProductEntity.pmProductEntity;
        BooleanExpression expression = qPmProductEntity.prodName.like("商%");
        System.out.println(productRepository.findAll(expression));
    }

    @Test
    public void testJoin() {
        QPmProductEntity qPmProductEntity = QPmProductEntity.pmProductEntity;
        QPmBrandEntity qPmBrandEntity = QPmBrandEntity.pmBrandEntity;

        List<PmProductEntity> products = jpaFactory.select(qPmProductEntity)
                .from(qPmProductEntity)
                .leftJoin(qPmBrandEntity)
                .on(qPmProductEntity.brandId.eq(qPmBrandEntity.id))
                .fetch();
        System.out.println(products);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testUpdate() {
        QPmProductEntity qPmProductEntity = QPmProductEntity.pmProductEntity;
        QPmBrandEntity qPmBrandEntity = QPmBrandEntity.pmBrandEntity;
        long num = jpaFactory.update(qPmProductEntity).set(qPmProductEntity.prodName, "哈哈哈")
                .where(qPmProductEntity.brandId.eq(Long.valueOf("1"))).execute();
        System.out.println(num);
    }


    @Test
    public void testUtil() throws Exception {
        QueryDslContext queryDslContext = new QueryDslContext();
        // 表
        queryDslContext.add(QPmProductEntity.pmProductEntity.id.as("id"));
        queryDslContext.add(QPmProductEntity.pmProductEntity.prodName.as("prodName"));
        queryDslContext.add(QPmProductEntity.pmProductEntity.model.as("model"));
        queryDslContext.add(QPmProductEntity.pmProductEntity.price.as("price"));
        queryDslContext.add(QPmBrandEntity.pmBrandEntity.brandName.as("brandName"));

        // 表
        queryDslContext.from(QPmProductEntity.pmProductEntity)
                .innerJoin(QPmBrandEntity.pmBrandEntity)
                .on(QPmProductEntity.pmProductEntity.brandId.eq(QPmBrandEntity.pmBrandEntity.id));

        // 条件
//        queryDslContext.add(QPmBrandEntity.pmBrandEntity.id.eq(QPmProductEntity.pmProductEntity.brandId));

        // 排序
        queryDslContext.add(QPmProductEntity.pmProductEntity.price.desc());

        PageResult pageResult = productService.queryDslForPageListResult(queryDslContext, ProductVO.class, 0, 10);
        System.out.println(pageResult);


    }

    @Test
    public void testTable() throws Exception {
        QPmProductEntity pmProductEntity = QPmProductEntity.pmProductEntity;
        ArrayList<Predicate> list = new ArrayList<>();
        BooleanExpression booleanExpression = pmProductEntity.brandId.eq(1L);
        list.add(booleanExpression);
        PageResult<PmProductEntity> result = productService.queryDsl(0, 10, list, pmProductEntity, null);
        System.out.println(result);
    }

}
