package com.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewNIOServer {

    public static void main(String[] args) throws IOException {

        InetSocketAddress inetSocketAddress = new InetSocketAddress(7001);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket socket = serverSocketChannel.socket();

        socket.bind(inetSocketAddress);

        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        while (true) {
            SocketChannel accept = serverSocketChannel.accept();
            int readcount = 0;

            while (-1 != readcount) {
                try {

                    readcount = accept.read(buffer);
                } catch (Exception e) {
                    break;
                }
                //倒带  positon=0 作废
                buffer.rewind();
            }
        }


    }
}
