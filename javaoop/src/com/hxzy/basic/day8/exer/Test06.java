package com.hxzy.basic.day8.exer;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @Description 6.判断一个五位数是否为回文数。
 * 提示：所谓回文数就是一个数的所有位对称，如12321就是回文数，  23432和45654也是回文数，输入一个数，判断是不是回文数。
 * @date 2019/5/4 14:27
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*System.out.println("请输入一个五位数：");
        int num = scanner.nextInt();
        int gw = num % 10;
        int sw = num / 10 % 10;
        //int bw = num / 100 % 10;
        int qw = num / 1000 % 10;
        int ww = num / 10000;
        if (gw == ww && sw == qw) {
            System.out.println("这个数是一个回文数");
        } else {
            System.out.println("这个数不是回文数");
        }*/

        System.out.println("请输入一个数：");
        long a = scanner.nextLong();
        long b = 0, bak = a;//将输入的数存储，后面需要取每个位的数字，例如：a = 12321
        while (a > 0) {//循环：当a = 0的时候结束
            b = b * 10 + a % 10;//将a的个位数字1作为b的最高位：b = 0 * 10 + 12321 % 10 = 1
            a = a / 10;//取a的十位数字
        }
        String str = b == bak ? "回文数" : "非回文数";//判断b是否和初始a相同
        System.out.println(str);
    }
}
