package com.hxzy.senior.day25.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    private List<Socket> sockets;

    public ChatServer() {
        this.sockets = new ArrayList<>();
        try {
            ServerSocket server = new ServerSocket(8899);
            while (true) {
                Socket socket = server.accept();
                sockets.add(socket);
                new ServerReceive(socket, sockets).start();
            }
        } catch (IOException e) {
            System.out.println("启动失败，端口被占用");
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}
