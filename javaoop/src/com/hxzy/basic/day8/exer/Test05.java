package com.hxzy.basic.day8.exer;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @Description 5.企业年底发放的奖金根据当年的利润提成。
 * 利润低于或等于10万元时，奖金可提10%；
 * 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可提成7.5%；
 * 20万到40万之间时，高于20万的部分，可提成5%；
 * 40万到60万之间时，高于40万元的部分，可提成3%；
 * 60万到100万之间时，高于60万元的部分，可提成1.5%，
 * 高于100万元时，超过100万元的部分按1%提成，输入当年的利润，求应发放奖金总数。
 * @date 2019/5/4 13:53
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入当年的利润：");
        double profit = scanner.nextDouble();
        double bonus;
        if (profit <= 10) {
            bonus = profit * 0.1;
        } else if (profit > 10 && profit < 20) {
            bonus = 10 * 0.1 + (profit - 10) * 0.075;
        } else if (profit >= 20 && profit < 40) {
            bonus = 10 * 0.1 + 10 * 0.075 + (profit - 20) * 0.05;
        } else if (profit >= 40 && profit < 60) {
            bonus = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + (profit - 40) * 0.03;
        } else if (profit >= 60 && profit < 100) {
            bonus = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + (profit - 60) * 0.015;
        } else {
            bonus = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + 40 * 0.015 + (profit - 100) * 0.01;
        }
        System.out.println("应发奖金总数为：" + bonus + "万元");
    }
}
