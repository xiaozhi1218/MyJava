package com.hxzy.basic.day4;

import java.util.Scanner;

public class Debug {
    public static void main(String[] args) {
        int a, b, c;
        System.out.println("请输入两个数：");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = a;
        if (b > c)
            c = b;
        System.out.println("==>" + c);
    }
}
