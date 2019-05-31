package com.hxzy.basic.day13;

/**
 * @author chenyongzhi
 * @description
 * @date 2019/5/10 9:46
 */
public class Person {
    private String name;
    private int age;
    private int sex;

    public Person() {
        this("我", 22, 1);//调用其他构造方法：this(参数)
    }


    public Person(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void study() {
        System.out.println("studying");
    }

    public void showAge() {
        System.out.println(name + "年龄为：" + age);
    }

    public void addAge(int i) {
        this.age += i;
    }


}
