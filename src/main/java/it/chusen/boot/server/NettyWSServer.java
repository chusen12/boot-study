package it.chusen.boot.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author chusen
 * @date 2020/1/19 16:41
 */
@Component
@Slf4j
public class NettyWSServer implements WSServer {

    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ChannelFuture future;

    public static class InnerClass {
        private static final NettyWSServer SERVER = new NettyWSServer();

        public static NettyWSServer getInstance() {
            return SERVER;
        }
    }

    @Override
    public void start() {
        // 开启服务
        bossGroup = new NioEventLoopGroup(1);
        workerGroup = new NioEventLoopGroup(8);
        ServerBootstrap serverBoot = new ServerBootstrap();
        serverBoot.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {

            }
        });
        try {
            log.info("Netty服务开始启动...");
            future = serverBoot.bind(10000).sync();
            future.addListener(future1 -> {
                if (future.isSuccess()) {
                    log.info("Netty服务启动成功...");
                }
            });
            System.out.println("----------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shutdown() {
        // 关闭服务
        log.info("开始关闭Netty服务");
        try {
            ChannelFuture future = this.future.channel().closeFuture();
            future.addListener((ChannelFutureListener) future1 -> {
                        if (bossGroup != null) {
                            bossGroup.shutdownGracefully().sync();
                        }
                        if (workerGroup != null) {
                            workerGroup.shutdownGracefully().sync();
                        }
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
