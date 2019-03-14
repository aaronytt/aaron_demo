package com.ytt.aaron_demo.netty.learn5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import static io.netty.channel.ChannelHandler.Sharable;

/**
 * @Author: aaron
 * @Descriotion: 编写自己一个处理器
 * @Date: 23:53 2019/3/14
 * @Modiflid By:
 */
@Sharable
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {


    /**
     * 构造自己内容，响应 方法名有名（messageReceived）
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        if(msg instanceof HttpRequest){
            //要返回的内容对象
            ByteBuf content = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);
            //支持响应的对象
            FullHttpResponse response =
                    new DefaultFullHttpResponse(
                            //协议版本
                            HttpVersion.HTTP_1_1,
                            //返回状态
                            HttpResponseStatus.OK,
                            //返回内容
                            content);

            //内容类型
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            //内容长度
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            //放到缓冲区里
//        ctx.write(response);
            //缓冲并刷新返回
            ctx.writeAndFlush(response);
        }

    }
}
