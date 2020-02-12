package it.chusen.boot.server;

/**
 * @author chusen
 * @date 2020/1/19 16:39
 */
public interface WSServer {
    /**
     * 开启服务
     */
    void start();

    /**
     * 关闭服务
     */
    void shutdown();
}
