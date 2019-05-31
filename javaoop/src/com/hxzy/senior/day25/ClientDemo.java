package com.hxzy.senior.day25;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {

    public static void main(String[] args) {
        try {
            Socket socket=new Socket("192.168.102.182",8899);
            System.out.println("连接服务器成功");

            new Receive(socket).start();

            Scanner keyBoard=new Scanner(System.in);
            PrintWriter out=new PrintWriter(socket.getOutputStream());
            while (true){
                String mess=keyBoard.nextLine();//从键盘输入消息
                out.write(mess+"\n");
                out.flush();//发送消息
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
