package com.atguigu.basic.day08.exer;

/**
 * @author chenyongzhi
 * @description
 * @create 2019/5/9 19:29
 */
public class Person {

    String name;
    int age;
    /**
     * sex:1 表明是男性
     * sex:0 表明是女性
     */
    int sex;

    public void study() {
        System.out.println("studying");
    }

    public void showAge() {
        System.out.println("age:" + age);
    }

    public int addAge(int i) {
        age += i;
        return age;
    }
}

