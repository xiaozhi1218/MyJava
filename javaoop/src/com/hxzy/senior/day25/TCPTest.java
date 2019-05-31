package com.hxzy.senior.day25;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author chenyongzhi
 * @date 2019/5/30 14:33
 */
public class TCPTest {

    @Test
    public void Server() throws IOException {


        ServerSocket serverSocket = new ServerSocket(7898);

        System.out.println("服务器已启动，等待连接...");
        Socket socket = serverSocket.accept();

        System.out.println(socket.getLocalAddress().getHostAddress() + "连接成功");
        Scanner scanner = new Scanner(socket.getInputStream());

        String str = scanner.nextLine();
        System.out.println(str);

        scanner.close();
        socket.close();
    }

    @Test
    public void Client() throws IOException {

        //InetAddress localHost = InetAddress.getLocalHost();
        //System.out.println(localHost);//192.168.102.182
        Socket socket = new Socket("192.168.102.182", 7898);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        printWriter.write("你好，客户端");
        printWriter.flush();

        printWriter.close();
        socket.close();
    }
}
