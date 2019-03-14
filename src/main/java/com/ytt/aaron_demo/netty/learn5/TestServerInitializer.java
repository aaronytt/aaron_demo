package com.ytt.aaron_demo.netty.learn5;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Author: aaron
 * @Descriotion: 自定义子处理器初始化器
 * @Date: 23:47 2019/3/14
 * @Modiflid By:
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        //类似于拦截器
        ChannelPipeline pipeline = ch.pipeline();

        //请求编解码用
        pipeline.addLast("httpServerCodec",new HttpServerCodec());
        //自定义子处理器
        pipeline.addLast("testHttpServerHandler",new TestHttpServerHandler());
    }

}
