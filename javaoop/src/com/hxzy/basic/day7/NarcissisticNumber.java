package com.hxzy.basic.day7;

public class NarcissisticNumber {
    public static void main(String[] args) {
        System.out.println("100-1000中的水仙花数有：");
        for (int i = 100; i < 1000; i++) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i /100 % 10;
            //判断是否为水仙花数：个位的三次方 + 十位的三次方 + 百位的三次方 = 这个数
            if (i == (ge * ge * ge + shi * shi * shi + bai * bai * bai)) {
                System.out.println(i);
            }
        }
    }
}
