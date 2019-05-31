package com.hxzy.basic.day8.exer;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @Description 4.接受用户输入一个正整数，求出该数的阶乘，如：例如：输入5，则计算5*4*3*2*1=120。
 * 要求：用while结构和for结构两种方法。
 * @date 2019/5/4 13:46
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        int num = scanner.nextInt();
        //while结构
        /*int result = 1;
        int i = 1;//初始化条件
        while (i <= num) {//循环条件
            result *= i;
            i++;//迭代条件
        }
        System.out.println("这个数的阶乘为：" + result)*/
        ;

        //for结构
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        System.out.println("这个数的阶乘为：" + result);
    }
}
