package it.chusen.boot.service;

import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;

/**
 * @author chusen
 * @date 2020/1/19 17:00
 */
public interface AsyncService {
    Future<Boolean> update();

    void find();

    Future<Boolean> insert();
}
