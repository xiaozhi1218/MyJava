package com.hxzy.basic.day5;

import java.util.Scanner;

public class ScoreTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的成绩：");
        int score = scanner.nextInt();

        //if条件为真时嵌套
        /*if (score >= 60) {
            if (score >= 80) {
                if (score >= 90) {
                    System.out.println("优秀");
                } else System.out.println("良好");
            } else System.out.println("合格");
        } else System.out.println("不合格");*/

        //if条件为假时嵌套
        /*if (score >= 90)
            System.out.println("优秀");
        else if (score >= 80)
            System.out.println("良好");
        else if (score >= 60)
            System.out.println("合格");
        else System.out.println("不合格");*/

        //if条件为真时嵌套，条件为假时也嵌套
        /*if (score >= 80) {
            if (score >= 90) {
                System.out.println("优秀");
            } else System.out.println("良好");
        } else if (score >= 60) {
            System.out.println("合格");
        } else System.out.println("不合格");*/
        switch (score / 10) {
            case 10:
            case 9:
                System.out.println("优秀");
                break;
            case 8:
                System.out.println("良好");
                break;
            case 7:
            case 6:
                System.out.println("合格");
                break;
            default:
                System.out.println("不合格");
        }
    }
}
