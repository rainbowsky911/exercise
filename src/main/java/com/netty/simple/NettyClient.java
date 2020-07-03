package com.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
      try{
          //事件循环组


          bootstrap.group(group)
                  .channel(NioSocketChannel.class)
                  .handler(new ChannelInitializer<SocketChannel>() {
                      @Override
                      protected void initChannel(SocketChannel ch) throws Exception {
                          ch.pipeline().addLast(new NettyClientHandler());        //加入自己处理器
                      }
                  });
          System.out.println("客户端ok。。");

          ChannelFuture channelFuture = bootstrap.connect("127.0.0.01", 6668).sync();
          channelFuture.channel().closeFuture().sync();
      }catch (Exception  e){

      }finally {
          group.shutdownGracefully();
      }
    }
}
