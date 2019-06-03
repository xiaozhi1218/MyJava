package com.hxzy.senior.day26;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenyongzhi
 * @create 2019/6/3 11:28
 */
public class TCPTest {

    @Test
    public void client() throws Exception {
        Socket socket = new Socket("192.168.102.182", 8899);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        FileInputStream fis = new FileInputStream("hello.txt");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }

        fis.close();
        bos.close();
        socket.close();

    }

    @Test
    public void server() throws Exception {
        ServerSocket ss = new ServerSocket(8899);

        Socket socket = ss.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        FileOutputStream fos = new FileOutputStream("hello3.txt");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = bis.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        fos.close();
        bis.close();
        socket.close();
        ss.close();
    }
}
