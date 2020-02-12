package it.chusen.boot.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author chusen
 * @date 2020/1/23 23:57
 */
@Data
@ToString
public class Color implements InitializingBean {
    private String color;

    public Color(){
        System.out.println("constructor....");
    }

    public Color(String color) {
        this.color = color;
        System.out.println("all constructor....");
    }

    public void init() {
        System.out.println("init method...");
    }

    public void destroy() {
        System.out.println("destroy method....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @PostConstruct
    public void postMethod() {
        System.out.println("post Method....");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy method....");
    }
}
