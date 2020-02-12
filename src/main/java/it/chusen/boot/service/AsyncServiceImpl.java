package it.chusen.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author chusen
 * @date 2020/1/19 17:00
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async
    public Future<Boolean> update() {
        log.info("开始文件上传....");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("上传文件耗时: {}", System.currentTimeMillis() - start);
        log.info("文件上传结束");
        return new AsyncResult<>(true);
    }

    @Override
    public void find() {

    }

    @Override
    @Async
    public Future<Boolean> insert() {
        log.info("开始插入....");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("插入结束 耗时: {}", System.currentTimeMillis() - start);
        log.info("结束插入...");
        return new AsyncResult<>(true);
    }
}
