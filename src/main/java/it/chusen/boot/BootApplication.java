package it.chusen.boot;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

/**
 * @author chusen
 * @date 2020/1/7 5:07 下午
 */
@SpringBootApplication
@EnableAsync
public class BootApplication {

    public static void main(String[] args) {
//        SpringApplication.run(BootApplication.class, args);
        SpringApplication springApplication = new SpringApplication(BootApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    public void test() {
//        ReflectionUtils.makeAccessible();
//        ClassUtils.getMethod()
//        BeanUtils.findMethod()
    }
}
