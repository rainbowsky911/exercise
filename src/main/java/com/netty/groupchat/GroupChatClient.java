package com.netty.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

public class GroupChatClient {

    private  final  String HOST="127.0.0.1";
    private  final  int PORT=6667;
    private  Selector selector;
    private  SocketChannel socketChannel;
    private  String username;

    //构造器 完成初始化工作
    public GroupChatClient() throws IOException {
        selector = Selector.open();

        //连接服务器
        socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", PORT));

        //设置非阻塞
        this.socketChannel.configureBlocking(false);

        //channel注册到selector
        this.socketChannel.register(selector, SelectionKey.OP_READ);

        //得到username
        this.socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(username+" is ok");

    }
    //向服务器发送信息
    public  void sendInfo(String info){
        info=username+"说"+info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        }catch (Exception e){
        }
    }
    //读取服务器信息
    public  void readInfo(){
        try {
            int select = selector.select();
            if(select>0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()){

                    //取出selectionKey
                    SelectionKey key = iterator.next();

                    //监听到accept
                    if(key.isReadable()){
                        SocketChannel channel = (SocketChannel) key.channel();

                        ByteBuffer buffer = ByteBuffer.allocate(1024);

                        channel.read(buffer);
                        String msg = new String(buffer.array());

                        System.out.println(msg.trim());
                    }
                }
            }else {
             //   System.out.println("没有可用的通道");
            }

        }catch (Exception e){

        }
    }

    public static void main(String[] args) throws IOException {

        GroupChatClient chatClient =new GroupChatClient();
         //启动一个线程
        new Thread(){
            @Override
            public void run() {
                while (true){
                    chatClient.readInfo();
                    try {
                        Thread.sleep(3000);
                    }catch (Exception e){

                    }
                }
            }
        }.start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();

            chatClient.sendInfo(s);
        }
    }
}
