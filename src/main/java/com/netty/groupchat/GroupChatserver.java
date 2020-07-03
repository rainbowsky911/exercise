package com.netty.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.stream.Stream;

public class GroupChatserver {

    private Selector selector;
    private  ServerSocketChannel listen;
    private  static  final  int PORTS=6667;

    public GroupChatserver() throws IOException {

        //得到选择器
        selector=Selector.open();


        listen=ServerSocketChannel.open();
        //绑定端口非阻塞
        listen.socket().bind(new InetSocketAddress(PORTS));
        //listen注册到selector
        listen.configureBlocking(false);

    }
    //监听
    public  void listen(){
        try {

            while (true){
                int cout = selector.select(2000);
                if(cout>0){
                    //遍历slection集合
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()){
                        //取出selectionkey
                        SelectionKey key = iterator.next();

                        //监听到accept
                        if(key.isAcceptable()){
                            SocketChannel sc = listen.accept();
                            sc.configureBlocking(false);

                            //将sc注册到seletor
                            sc.register(selector,SelectionKey.OP_ACCEPT);
                            System.out.println(sc.getRemoteAddress()+"上线");
                        }
                        //通道发送read事件 通道可读
                        if(key.isReadable()){

                            readDate(key);
                        }
                        iterator.remove();
                    }
                }
                else {
                    System.out.println("等待...");
                }

            }
        }catch (Exception e){

        }finally {

        }
    }
    //读取客户端信息
    public  void readDate(SelectionKey key){
        //取到关联的channel
        SocketChannel channel =null;
        try {
            //取到关联的channel
            channel= (SocketChannel) key.channel();

            //创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int count = channel.read(buffer);
            if(count>0){
                //缓存区数据转成字符串
                String msg = new String(buffer.array());
                System.out.println("from 客户端"+msg);

                sendInfoToOtherClents(msg,channel);

                //向其他客户端发送信息
            }

        }catch ( Exception e){
            try {
                System.out.println(channel.getRemoteAddress()+"离线了");
                //取消注册
                key.cancel();
                //关闭通道
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    //转发消息给其他客户

    private  void sendInfoToOtherClents(String msg,SocketChannel self) throws IOException {
        System.out.println("服务器转发消息");
        //遍历注册到selector上的sockerchannel      排除self

        for (SelectionKey key:selector.keys()
             ) {
            //
            Channel targetchannel = key.channel();
            //排除自己
            if(targetchannel instanceof  SocketChannel &&targetchannel!=self){
                //转型
                SocketChannel  dest = (SocketChannel) targetchannel;
                //msg写入buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());

                //Bbuffer写入通道
                dest.write(buffer);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        GroupChatserver groupChatserver =new GroupChatserver();
        groupChatserver.listen();

    }
}
