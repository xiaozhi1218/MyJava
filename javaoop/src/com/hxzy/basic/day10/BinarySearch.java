package com.hxzy.basic.day10;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @version v1.0
 * @Description
 * @creat 2019/5/7 8:54
 */


public class BinarySearch {
    public static void main(String[] args) {
        int[] b = new int[]{5, 9, 1, 4, 16, 8};
        //冒泡排序
        for (int i = 0; i < b.length - 1; i++) {//外层比较 n-1 次
            for (int j = 0; j < b.length - 1 - i; j++) {//内层比较 n-1-i 次，每次比较一轮，找出一个最大的数，所以减去i次
                if (b[j] > b[j + 1]) {
                    int temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        //二分查找
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的值：");
        int value = scanner.nextInt();
        int head = 0;//初始的首索引
        int end = b.length - 1;//初始的末索引
        boolean isFlag = true;
        while (head <= end) {

            int middle = (head + end) / 2;//取整数部分

            if (value == b[middle]) {
                System.out.println("找到了指定的元素，位置为：" + middle);
                isFlag = false;
                break;
            } else if (b[middle] > value) {
                end = middle - 1;
            } else {//arr2[middle] < dest1
                head = middle + 1;
            }


        }

        if (isFlag) {
            System.out.println("很遗憾，没有找到！");
        }
    }
}