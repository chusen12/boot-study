package it.chusen.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chusen
 * @date 2020/1/7 5:08 下午
 */
@RestController
@RequestMapping("/index")
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello world!";
    }
}
