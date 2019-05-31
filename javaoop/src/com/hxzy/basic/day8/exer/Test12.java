package com.hxzy.basic.day8.exer;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @Description 12.在屏幕上打印出n行的金字塔图案，如，若n=5,则图案如下：
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 * @date 2019/5/4 15:18
 */
public class Test12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入行数：");
        int n = scanner.nextInt();
        /*
        1.首先把菱形看成上下两部分，比如：这里n取5,表示上部分有五行，下部分有四行
        2.上下两个部分分别用for循环来输出
         */
        //上半部分
        for (int i = 1; i <= n; i++) {//n = 5, i控制行数
            //输出"-"
            for (int j = 1; j <= n - i; j++) {//j为4、3、2、1
                System.out.print("-");
            }
            //输出"*"
            for (int k = 1; k <= 2 * i - 1; k++) {//找规律，k是1、3、5、7的奇数
                System.out.print("*");
            }
            System.out.println();//换行
        }
        //下半部分
        for (int i = 1; i <= n - 1; i++) {//n = 4, i控制行数
            //输出"-"
            for (int j = 1; j <= i; j++) {//j为1、2、3、4
                System.out.print("-");
            }
            //输出"*"
            for (int k = (n - 1) * 2 - 1; k >= 2 * i - 1; k--) {//找规律，k是7、5、3、1，找到n=5和7的关系
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
