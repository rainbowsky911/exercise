package com.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


      /*  Thread.sleep(10*1000);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello喵喵",CharsetUtil.UTF_8));
        System.out.println("go on");*/

     /* ctx.channel().eventLoop().execute(new Runnable() {
          @SneakyThrows
          @Override
          public void run() {
             try{
                 Thread.sleep(5*1000);
                 ctx.writeAndFlush(Unpooled.copiedBuffer("hello喵2",CharsetUtil.UTF_8));
                 System.out.println("channel code=" + ctx.channel().hashCode());
             }catch (Exception ex){
                 System.out.println("发生异常" + ex.getMessage());

             }finally {

             }
          }
      });*/
      ctx.channel().eventLoop().schedule(new Runnable() {
          @Override
          public void run() {
                try{
                    Thread.sleep(5*1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello喵3",CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
          }
      },5,TimeUnit.SECONDS);

        System.out.println("go on");

     /*   System.out.println("服务器读取线程 " + Thread.currentThread().getName() + " channle =" + ctx.channel());
        System.out.println("server ctx =" + ctx);
        System.out.println("看看channel 和 pipeline的关系");
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline(); //本质是一个双向链接, 出站入站

       ByteBuf buf= (ByteBuf) msg;
        System.out.println("客户端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址:" + channel.remoteAddress());*/

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
       ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
       ctx.channel().close();
    }
}
