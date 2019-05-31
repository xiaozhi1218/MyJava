package com.hxzy.basic.day12;

/**
 * @author chenyongzhi
 * @description
 * @date 2019/5/9 11:23
 */
public class Person {

    private String name;
    private int age;
    private boolean isHuman;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public void show() {
        System.out.println("姓名是：" + name + "，年龄是：" + age);
    }
}
