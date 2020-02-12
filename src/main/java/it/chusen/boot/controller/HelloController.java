package it.chusen.boot.controller;

import it.chusen.boot.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author chusen
 * @date 2020/1/7 5:08 下午
 */
@Slf4j
@RestController
@Async
@RequestMapping("/index")
public class HelloController {

    @Resource
    private AsyncService asyncService;

    @GetMapping
    public String hello() {
        log.info("hello............");
        return "hello world!";
    }


    @GetMapping("/hello2")
    public String hello2() {
        log.info("hello2.....");
        return "hello world!";
    }


    @GetMapping("/async")
    public String async() throws ExecutionException {
        log.info("controller执行...");
        long start = System.currentTimeMillis();
        Future<Boolean> update = asyncService.update();
        Future<Boolean> insert = asyncService.insert();
        while (!update.isDone() || insert.isDone()) {
            if (update.isDone() && insert.isDone()) {
                break;
            }
        }

        log.info("总耗时,{} ", System.currentTimeMillis() - start);
        return "success";
    }

}
