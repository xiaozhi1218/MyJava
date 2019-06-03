package com.hxzy.senior.day26;

import org.junit.Test;

import java.lang.annotation.Target;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author chenyongzhi
 * @create 2019/6/3 10:29
 */
public class UDPTest {

    @Test
    public void send() throws Exception {

        DatagramSocket socket = new DatagramSocket(8899);

        String str = "hello,world!";
        byte[] data = str.getBytes();
        InetAddress address = InetAddress.getByName("192.168.102.182");

        DatagramPacket packet = new DatagramPacket(data, data.length, address, 9988);

        socket.send(packet);
        socket.close();
    }

    @Test
    public void receive() throws Exception {
        DatagramSocket socket = new DatagramSocket(9988);

        byte[] data = new byte[100];

        DatagramPacket packet = new DatagramPacket(data, data.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));

    }

}
