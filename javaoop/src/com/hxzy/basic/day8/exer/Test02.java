package com.hxzy.basic.day8.exer;

/**
 * @author chenyongzhi
 * @Description 2.求1-100以内的奇数和。
 * 要求：用while结构和for结构两种方法。
 * @date 2019/5/4 13:28
 */
public class Test02 {
    public static void main(String[] args) {
        //while结构①
        /*int i = 1;
        int sum = 0;//初始化条件
        while (i <= 100) {//循环条件
            //循环体：遍历1-100以内的奇数和
            if (i % 2 != 0) {
                System.out.println(i);
                sum += i;
            }
            i++;//迭代条件
        }
        System.out.println(sum);*/

        //while结构②
        /*int i = 1;
        int sum = 0;
        while (i <= 100) {
            System.out.println(i);
            sum += i;
            i += 2;
        }
        System.out.println(sum);*/

        //for结构①
        /*int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);*/

        //for结构②
        int sum = 0;
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(i);
            sum += i;
        }
        System.out.println(sum);
    }
}
