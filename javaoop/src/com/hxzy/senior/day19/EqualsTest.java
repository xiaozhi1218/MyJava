package com.hxzy.senior.day19;

/**
 * @author chenyongzhi
 * @date 2019/5/20 10:27
 */
public class EqualsTest {

    public static void main(String[] args) {
        People p1 = new People("张三",12);
        People p2 = new People("张三",12);

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println(p2.hashCode() == p1.hashCode());
    }
}
