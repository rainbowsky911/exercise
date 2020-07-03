package com.netty.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIoClient {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.connect(new InetSocketAddress("localhost", 7001));
        String fileName = "protoc-3.6.1-win32.zip";

        //得到一个文件channel
        FileChannel channel = new FileInputStream(fileName).getChannel();

        //准备发送
        long startTime = System.currentTimeMillis();

        long trans = channel.transferTo(0, channel.size(), socketChannel);


        System.out.println("发送的总的字节数=" + trans + "耗时:");
        System.out.println(System.currentTimeMillis() - startTime);

        //关闭
        channel.close();

    }
}
