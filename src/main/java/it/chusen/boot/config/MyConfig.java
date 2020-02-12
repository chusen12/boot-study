package it.chusen.boot.config;

import it.chusen.boot.annotate.MyAnnotate;
import it.chusen.boot.annotate.MyMode;
import it.chusen.boot.model.req.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chusen
 * @date 2020/1/17 11:20 上午
 */
@Configuration
public class MyConfig {


    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Color color() {
        return new Color("黄色");
    }

    @Bean
    public MyFactoryBean myFactoryBean() {
        return new MyFactoryBean();
    }

//    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
