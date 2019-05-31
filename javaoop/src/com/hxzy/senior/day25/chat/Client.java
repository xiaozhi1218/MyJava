package com.hxzy.senior.day25.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.102.188", 10000);
            System.out.println("连接服务器成功");

            new Receive(socket).start();

            Scanner keyBoard = new Scanner(System.in);
            //PrintWriter out=new PrintWriter(socket.getOutputStream());
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                String mess = keyBoard.nextLine();//从键盘输入消息
                out.write(mess + "\n");
                out.flush();//发送消息
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
