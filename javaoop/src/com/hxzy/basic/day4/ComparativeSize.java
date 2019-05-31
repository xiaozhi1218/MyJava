package com.hxzy.basic.day4;

import java.util.Scanner;

public class ComparativeSize {
    public static void main(String[] args) {
        float a, b, c, max;
        System.out.println("请输入三个整数：");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextFloat();
        b = scanner.nextFloat();
        c = scanner.nextFloat();
        max = a;
        if (a < b)
            max = b;
        if (max < c)
            max = c;
        System.out.println("最大值为：" + max);
    }
}
