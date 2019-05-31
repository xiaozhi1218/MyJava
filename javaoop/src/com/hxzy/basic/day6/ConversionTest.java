package com.hxzy.basic.day6;
/**
 * 十进制转换为二进制
 */

import java.util.Scanner;

public class ConversionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个十进制数：");
        int x = scanner.nextInt();
        String s = "";
        while (x != 0) {
            s = x % 2 + s;
            x = x / 2;
        }
        System.out.println("二进制为：" + s);
    }
}
