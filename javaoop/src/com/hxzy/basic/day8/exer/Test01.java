package com.hxzy.basic.day8.exer;

/**
 * @author chenyongzhi
 * @Description 1.编写程序，打印出100以内所有5的倍数，如：100，95，90，85，……，5。
 * 要求：用while结构和for结构两种方法。
 * @date 2019/5/4 13:13
 */
public class Test01 {
    public static void main(String[] args) {
        //while结构①
       /* int i = 1;//初始化条件
        while (i <= 100) {//循环条件
            //循环体：遍历100以内所有5的倍数
            if (i % 5 == 0) {
                System.out.print(i + " ");
            }
            i++;//迭代条件
        }
        System.out.println("\n");*/

        //while结构②
        /*int i = 100;
        while (i > 0) {
            System.out.print(i + " ");
            i -= 5;
        }*/

        //for结构①
        /*for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0) {
                System.out.print(i + " ");
            }
        }*/

        //for结构②
        for (int i = 100; i > 0; i -= 5) {
            System.out.print(i + " ");
        }
    }
}
