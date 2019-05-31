package oop.basic.day01.exer2;

/**
 * @author chenyongzhi
 * @description
 * @create 2019/5/11 13:18
 */
public class Person {

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
        System.out.println("age = " + age);
    }

    public int addAge(int i) {
        age += i;
        return age;
    }
}
