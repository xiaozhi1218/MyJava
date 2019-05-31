package com.hxzy.basic.day12;

/**
 * @author chenyongzhi
 * @description
 * @date 2019/5/9 14:45
 */
public class Person1 {
    public static void main(String[] args) {

        Person p1 = new Person();
        Person p2 = new Person();
        p1.setName("张三");
        p1.show();

        p2.setAge(5);
        p2.show();
    }
}
