package com.hxzy.basic.day1;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {
        //利用Scanner从控制台输入
        Scanner scanner = new Scanner(System.in);
        int a, b;
        System.out.println("请输入两个数：");
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println("这两个数的和是：" + (a + b));
    }
}
