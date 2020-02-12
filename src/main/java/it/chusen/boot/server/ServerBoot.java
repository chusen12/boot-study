package it.chusen.boot.server;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author chusen
 * @date 2020/1/19 17:52
 */
@Component
public class ServerBoot implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            NettyWSServer.InnerClass.getInstance().start();
        }
    }
}
