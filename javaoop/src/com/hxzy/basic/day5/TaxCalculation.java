package com.hxzy.basic.day5;

import java.util.Scanner;

public class TaxCalculation {
    public static void main(String[] args) {
        float sum;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的工资：");
        sum = scanner.nextFloat();
        sum -= 5000;
        if (sum > 5000) {
            if (sum > 12000) {
                if (sum > 25000) {
                    if (sum > 35000) {
                        if (sum > 55000) {
                            if (sum > 80000) {
                                System.out.println("应缴税：" + sum * 0.45);
                            } else System.out.println("应缴税：" + sum * 0.35);
                        } else System.out.println("应缴税：" + sum * 0.3);
                    } else System.out.println("应缴税：" + sum * 0.25);
                } else System.out.println("应缴税：" + sum * 0.2);
            } else System.out.println("应缴税：" + sum * 0.1);
        } else System.out.println("应缴税：" + (sum + 5000));
    }
}
