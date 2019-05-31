package com.hxzy.basic.day12;

/**
 * @author chenyongzhi
 * @description
 * @date 2019/5/9 15:03
 */
public class Person2 {
    private String name;
    private int age;
    private int sex;

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

class Test {
    public static void main(String[] args) {
        Person2 p1 = new Person2();
        p1.study();
        p1.setName("Tom");
        p1.setAge(5);
        p1.addAge(2);
        p1.showAge();
    }
}
