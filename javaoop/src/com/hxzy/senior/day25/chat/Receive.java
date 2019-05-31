package com.hxzy.senior.day25.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receive extends Thread {

    private Socket socket;

    public Receive(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String mess=reader.readLine();
                System.out.println("==>"+mess);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
