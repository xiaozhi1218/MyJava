package com.hxzy.senior.day19;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @date 2019/5/20 16:00
 */
public class RegularExpressionTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入电话号码：");
        String phoneNumber = scanner.next();
        String regex = "1[3587][0-9]{9}";
        System.out.println("phoneNumber："+phoneNumber.matches(regex));
    }
}






