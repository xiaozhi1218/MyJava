package com.hxzy.basic.day3;

/**
 * 位运算符
 */
public class BitwiseOperators {
    public static void main(String[] args) {
        System.out.println(~10);
        //0000 1010
        //1111 0101
        //0010 1000
        //以最快速度计算8*4的结果
        //int insult = 8 * 4;
        //0000 1000  8
        //0010 0000  32
        System.out.println(8 << 2);//最快的计算速度
        //左移算法：位移数作为2的次幂与操作数相乘，2的几次方就移几位
        // 8 * 8
        // 8 << 3
        //10 << 2 = 40;
        //右移算法：操作数除以位移数的2次幂

        //40 >> 2 = 10
        //10 >> 1
        System.out.println(10 >> 1);
        //通过键盘输入，初始化两个数将这两个数交换位置后，输出显示交换后的数据。
        //Scanner input = new Scanner(System.in);
        //System.out.println("请输入第一个数：");
        //int a = input.nextInt();
        //System.out.println("请输入第二个数：");
        //int b = input.nextInt();

        //（1）通过第三个变量来交换
        //int c = a;
        //a = b;
        //b = c;
        //System.out.println("a=" + a + ",b=" + b);

        //2.不通过第三个变量如何交换两个数
        //(1)通过表达式
        //a=1,b=2
        //a = a + b - (b = a);

        //(2)通过+-计算
        int a = 1;
        int b = 2;
        //a = a + b;
        //b = a - b;
        //a = a - b;

        //（3）通过异或，两个数交换位置最快的方法
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        //（4）乘除也可以
        System.out.println("a=" + a + ",b=" + b);
    }
}
