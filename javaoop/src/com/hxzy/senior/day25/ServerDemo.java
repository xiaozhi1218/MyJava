package com.hxzy.senior.day25;

import com.hxzy.senior.day25.chat.Receive;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDemo {

    public static void main(String[] args) {
        try {
            ServerSocket server=new ServerSocket(8899);
            System.out.println("服务器已启动,等待客户机的连接...");
            Socket socket= server.accept();

            new Receive(socket).start();

            Scanner keyBoard=new Scanner(System.in);
            PrintWriter out=new PrintWriter(socket.getOutputStream());
            while (true){
                String mess=keyBoard.nextLine();//从键盘输入消息
                out.write(mess+"\n");
                out.flush();//发送消息
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("端口号被占用");
        }
    }
}
