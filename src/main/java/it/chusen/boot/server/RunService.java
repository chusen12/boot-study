package it.chusen.boot.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author chusen
 * @date 2020/1/20 10:29 下午
 */
@Component
public class RunService implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("run....");
    }
}
