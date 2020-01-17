package it.chusen.boot.service;

import it.chusen.annotation.MyAnnotation;
import org.springframework.stereotype.Service;

/**
 * @author chusen
 * @date 2020/1/17 5:12 下午
 */
@Service
public class AutoImportService {

    @MyAnnotation(name = MyAnnotation.MyType.GXC)
    public void test() {
        System.out.println("this is test method!");
    }

}
