package com.hxzy.basic.day2;

import java.util.Scanner;

/**
 * 从键盘输入一个声明初始化一个圆柱体的高和底面半径，π值为3.14，求圆柱体的体积，
 * 并显示输出圆柱体的体积：；π(r^2)h
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入圆柱体的高：");
        int h = input.nextInt();
        System.out.println("请输入圆柱体的底面半径：");
        int r = input.nextInt();
        float result = 3.14f * r * r * h;
        System.out.println("圆柱体的体积是：" + result);
    }
}
