package it.chusen.boot.annotate;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author chusen
 * @date 2020/1/17 10:06 上午
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyConfigurationSelector.class)
public @interface MyAnnotate {

    MyMode name() default MyMode.CS;


    String value() default "";

}
