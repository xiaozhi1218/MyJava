package com.hxzy.basic.day2;

import java.util.Scanner;

/**
 * 根据天数（46）计算周数和剩余的天数，天数是通过键盘输入。
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个天数：");
        int day = input.nextInt();
        int week = day / 7;
        int surplus = day % 7;
        System.out.println("周数为：" + week);
        System.out.println("剩余天数为：" + surplus);
    }

}
