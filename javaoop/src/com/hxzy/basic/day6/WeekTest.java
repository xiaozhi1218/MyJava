package com.hxzy.basic.day6;
/**
 * 输入年月日，判断并输出这天是星期几
 */

import java.util.Scanner;

public class WeekTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年月日："); //从键盘输入年、月、日
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int add = 0;//定义一个计数器
        //找出1900年到输入的年份之间有几个闰年。
        for (int i = 1900; i < year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0))
                add++;//闰年判断：1.能被4整除，并且不能被100整除 2.能被400整除
        }

        int yearDay = (year - 1900) * 365 + add;//计算出年的天数（普通年份天数加上闰年的天数）
        //计算月份的天数。例如4月29日，月份总天数为1,2,3月的天数和
        int monthDay = 0;
        for (int i = 1; i <= month - 1; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                monthDay = monthDay + 31;//1,3,5,7,8,10,12月每个月有31天
            }
            if (i == 2) {//2月天数需要判断是平年还是闰年
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    monthDay = monthDay + 29;//闰年的2月有29天
                } else monthDay = monthDay + 28;//平年的2月有28天
            }
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                monthDay = monthDay + 30;//4,6,9,11月每个月有30天
            }
        }

        int sumDay = yearDay + monthDay + day;//总的天数 = 年份天数 + 月份天数 + 当月天数
        switch (sumDay % 7) {//总的天数对7求余，输出是星期几。
            case 0:
                System.out.println(year + "年" + month + "月" + day + "日是星期天");
                break;
            case 1:
                System.out.println(year + "年" + month + "月" + day + "日是星期一");
                break;
            case 2:
                System.out.println(year + "年" + month + "月" + day + "日是星期二");
                break;
            case 3:
                System.out.println(year + "年" + month + "月" + day + "日是星期三");
                break;
            case 4:
                System.out.println(year + "年" + month + "月" + day + "日是星期四");
                break;
            case 5:
                System.out.println(year + "年" + month + "月" + day + "日是星期五");
                break;
            case 6:
                System.out.println(year + "年" + month + "月" + day + "日是星期六");
                break;
        }
    }
}

