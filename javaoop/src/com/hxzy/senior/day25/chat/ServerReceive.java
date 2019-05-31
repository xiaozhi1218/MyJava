package com.hxzy.senior.day25.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServerReceive extends Thread {

    private Socket socket;//从该socket接收消息

    private List<Socket> sockets;//向所有socket转发消息

    public ServerReceive(Socket socket, List<Socket> sockets) {
        this.socket = socket;
        this.sockets = sockets;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String mess = reader.readLine();
                sendMessage(mess);
            }
        } catch (IOException e) {
            String ip = socket.getInetAddress().getHostAddress();
            sockets.remove(socket);
            sendMessage(ip + "离开了\n");
            //e.printStackTrace();
        }
    }

    private void sendMessage(String mess) {
        for (Socket s : sockets) {
            try {
                PrintWriter out = new PrintWriter(s.getOutputStream());
                out.write(mess + "\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
