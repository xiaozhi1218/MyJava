package com.hxzy.basic.day4;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @title: ScoreLever
 * @projectName MyJava
 * @description:
 * @date 2019/4/26 10:05
 */
public class ScoreLever {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的成绩：");
        int s = scanner.nextInt();
        String result = s < 90 ? s < 80 ? s < 60 ? "不合格" : "合格" : "良好" : "优秀";
        System.out.println("你的成绩等级为：" + result);
    }
}
