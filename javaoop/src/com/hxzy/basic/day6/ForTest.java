package com.hxzy.basic.day6;

import java.util.Scanner;

public class ForTest {
    public static void main(String[] args) {
        //1-100的和
        /*int s = 0;
        for (int i = 0; i <= 100; i++) {
            s = s + i;
        }
        System.out.println(s);*/

        //1-100的偶数和:2550
        /*int s = 0;
        for (int i = 0; i <= 100; i += 2) {
            s = s + i;
        }
        System.out.println(s);*/

        //1-100的奇数和:2500
       /* int s = 0;
        for (int i = 1; i <= 100; i += 2) {
            s = s + i;
        }
        System.out.println(s);*/

        //输出阶乘结果
       /* Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int x = scanner.nextInt();
        int s = 1;
        for (int i = 1; i <= x; i++) {
            s = s * i;
        }
        System.out.println("阶乘结果为：" + s);*/

        //输出x^y的乘方结果
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int s = 1;
        for (int i = 1; i <= y; i++) {
            s = s * x;
        }
        System.out.println(s);*/

        //十进制数转为二进制数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个十进制数：");
        int n = scanner.nextInt();
        String s = "";
        for (; n > 0; n /= 2) {
            s = n % 2 + s;
        }
        System.out.println("这个数二进制表示为：" + s);
    }
}
