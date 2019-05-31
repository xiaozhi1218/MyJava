package com.hxzy.basic.day13;

/**
 * @author chenyongzhi
 * @description
 * @date 2019/5/10 9:44
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("张三", 25, 1);
        p1.study();
        p1.addAge(2);
        p1.showAge();

        System.out.println("----------------------");

        Person p2 = new Person();
        p2.study();
        p2.setName("李四");
        p2.setAge(23);
        p2.addAge(3);
        int sex = p2.getSex();
        System.out.println(sex);
    }
}
