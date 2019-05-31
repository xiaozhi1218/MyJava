package com.hxzy.basic.day6;

import java.util.Scanner;

public class WhileTest {
    public static void main(String[] args) {
        /*int c = 0;
        while (c < 5) {
            System.out.print("*");
            c++;
        }
        System.out.println("结束");*/

        //1-100的和
        /*int s, i;
        s = 0;
        i = 1;
        while (i <= 100) {
            s = s + i;
            i++;
        }
        System.out.println(s);*/

        //1-100的奇数和
        /*int s, i;
        s = 0;
        i = 1;
        while (i <= 100) {
            s = s + i;
            i += 2;
        }
        System.out.println("1-100的奇数和为：" + s);*/

        //1-100的偶数和
       /* int j, k;
        j = 0;
        k = 2;
        while (k <= 100) {
            j += k;
            k += 2;
        }
        System.out.println("1-100的偶数和为：" + j);*/

        int i, s, j, k;
        i = 1;//控制循环次数
        s = 1;//阶乘结果
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = scanner.nextInt();
        while (i <= n) {
            s = s * i;
            i++;
        }
        System.out.println("这个数的阶乘结果为：" + s);
        System.out.println("请在输入两个数：");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        j = 1;//控制循环次数
        k = 1;//乘积
        while (j <= y) {
            k = k * x;
            j++;
        }
        System.out.println("这个数的乘方为：" + k);
    }
}