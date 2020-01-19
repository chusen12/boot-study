package it.chusen.boot.map;

import org.springframework.stereotype.Component;

/**
 * @author chusen
 * @date 2020/1/18 2:01 上午
 */
@Component
public class MyDemoMap implements MyMap {
    @Override
    public int number() {
        return 1;
    }

    @Override
    public void name() {
        System.out.println("chusen");
    }
}
