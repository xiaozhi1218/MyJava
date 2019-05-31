package com.hxzy.basic.day11;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @description String类方法的使用
 * @date 2019/5/8 11:05
 */
public class StringTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的身份证号码：");
        String id = scanner.next();
        //530112199512180013  6-13
        String year = id.substring(6, 10);//左闭右开
        String month = id.substring(10, 12);
        String day = id.substring(12, 14);
        String sex = id.substring(16, 17);
        if (Integer.valueOf(sex) % 2 == 0) {
            System.out.println("女士，你的出生日期是：" + year + "年" + month + "月" + day + "日");
        } else {
            System.out.println("先生，你的出生日期是：" + year + "年" + month + "月" + day + "日");
        }


    }
}
