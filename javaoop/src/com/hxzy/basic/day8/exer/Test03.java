package com.hxzy.basic.day8.exer;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @Description 3.接受用户输入一个整数，计算从1到该整数的和，如：输入50，则计算1+2+3……50的和。
 * 要求：用while结构和for结构两种方法。
 * @date 2019/5/4 13:39
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = scanner.nextInt();
        //while结构
       /* int i = 1;
        int sum = 0;//初始化条件
        while (i <= num) {//循环条件
            sum += i;
            i++;//迭代条件
        }
        System.out.println("1到该整数的和为：" + sum);*/

        //for结构
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println("1到该整数的和为：" + sum);
    }
}
