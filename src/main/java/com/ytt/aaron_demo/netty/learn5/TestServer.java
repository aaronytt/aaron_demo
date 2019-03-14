package com.ytt.aaron_demo.netty.learn5;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:41 2019/3/14
 * @Modiflid By:
 */
public class TestServer {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 老板分发给工人去做
            serverBootstrap.group(bossGroup,workerGroup)
                    //通道 NioServerSocketChannel反射创建
                    .channel(NioServerSocketChannel.class)
                    //子处理器初始化器
                    .childHandler(new TestServerInitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
