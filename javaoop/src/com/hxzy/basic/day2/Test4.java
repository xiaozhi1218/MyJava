package com.hxzy.basic.day2;

/**
 * &与&&的区别
 */
public class Test4 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        //boolean a = true;
        //boolean b = false;
        int c = (a++) & (b++);
        //int c = (!a) & b;
        //&：在逻辑运算时分别计算表达式两边的结果，再做&运算，在做位运算时&表示按位与
        //&&短路与运算，先计算左边的表达式，如果结果是false，那么不用计算右边的表达式，直接返回false
        //如果左边的表达式结果为true，再计算右边的表达式，如果右边的表达式为true，结果为true，否则为false
        //| 和 ||的原理同上
        //所以短路与 或 短路或的计算效率更高，建议使用。
    }
}
