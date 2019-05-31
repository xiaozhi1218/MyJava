package com.hxzy.basic.day2;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c, d, e;
        System.out.print("请输入一个四位数：");
        a = scanner.nextInt();
        b = a % 10;
        c = a / 10 % 10;
        d = a / 100 % 10;
        e = a / 1000;
        System.out.println(a + "的个位是：" + b + ",十位是：" + c + ",百位是：" + d + ",千位是：" + e + "。");
    }
}
