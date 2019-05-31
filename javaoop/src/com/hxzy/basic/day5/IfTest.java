package com.hxzy.basic.day5;

import java.util.Scanner;

public class IfTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入成绩：");
        float s = input.nextFloat();
        if (s >= 60 && s < 100) {
            if (s >= 80) {
                if (s >= 90) {
                    System.out.println("优秀");
                } else System.out.println("良好");
            } else System.out.println("合格");
        } else if (s < 0 || s > 100) {
            System.out.println("成绩无效，请重新输入：");
        } else System.out.println("不合格");
    }
}
