package it.chusen.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author chusen
 * @date 2020/1/19 17:00
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async
    public void update() {
        log.info("开始文件上传....");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("文件上传结束");
    }

    @Override
    public void find() {

    }

    @Override
    @Async
    public void insert() {
        log.info("开始插入....");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("结束插入...");
    }
}
