package com.hxzy.basic.day1;

/**
 * 基本数据类型转换
 */
public class TypeConversion {
    public static void main(String[] args) {
        /*
        容量小的类型自动转换为容量大的类型
        float和double是属于近似值
        byte，char，short，int,long属于精确值
        精确值转换为近似值可能丢失精度
         */

        byte b = 10;
        short s = b;//把一个字节赋值给一个短整型变量，自动转换
        int i = s;//把一个短整型赋值给一个整型变量，自动转换
        long lon = i;

        //char -> int 自动转换
        char sex = '男';
        int sex2 = sex;
        System.out.println(sex2);

        float f = 20f;
        double d = f;
        System.out.println(d);

        int num = 214532486;
        float num2 = num;//如果用于表示货币值，不建议用float或double
        System.out.println(num2);

        // byte，short，int，在计算时自动转换为int类型
        short s1 = 10;
        //int s2 = s1 + 1;//这里1是int型，所以接受值得类型要为int型
        s1 = (short) (s1 + 1);//强制类型转换
        System.out.println(s1);

        //把大的容量类型转换为小的容量类型，需要添加强制类型转换，有可能造成精度降低或数据溢出。
        int x = (int) lon;
    }
}
