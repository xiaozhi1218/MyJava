package com.hxzy.basic.day2;

/**
 * 定义一个五位数，求各位上的数的和
 */
public class Test2 {
    public static void main(String[] args) {
        int num = 54321;
        int gw = num % 10;
        int sw = num / 10 % 10;
        int bw = num / 100 % 10;
        int qw = num / 1000 % 10;
        int ww = num / 10000;
        int sum = gw + sw + bw + qw + ww;
        System.out.println(sum);
    }
}
