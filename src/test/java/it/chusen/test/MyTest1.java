package it.chusen.test;

import it.chusen.boot.BootApplication;
import it.chusen.boot.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author chusen
 * @date 2020/1/19 16:58
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("local")
@SpringBootTest(classes = BootApplication.class)
public class MyTest1 {


    @Resource
    private AsyncService asyncService;

    @Test
    public void test() {
        asyncService.insert();
        asyncService.update();
    }

}
