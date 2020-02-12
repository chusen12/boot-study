package it.chusen.test;

import it.chusen.boot.config.MyConfig;
import it.chusen.boot.config.MyFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chusen
 * @date 2020/1/24 0:00
 */
@SpringBootTest
@ActiveProfiles("local")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MyConfig.class})
public class BeanTest {

    private AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
    @Test
    public void test() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
//        Object myFactoryBean = applicationContext.getBean("&myFactoryBean");
//        System.out.println(myFactoryBean.getClass());
        applicationContext.close();

    }
}
