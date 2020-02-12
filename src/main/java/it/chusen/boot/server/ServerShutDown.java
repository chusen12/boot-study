package it.chusen.boot.server;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * @author chusen
 * @date 2020/1/20 11:21 下午
 */
@Component
public class ServerShutDown implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            NettyWSServer.InnerClass.getInstance().shutdown();
        }
    }
}
