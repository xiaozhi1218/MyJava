package oop.basic.day04.exer1;

/**
 * @author chenyongzhi
 * @date 2019/5/13 9:51
 */
public class Person {

    private String name;
    private char sex;
    private int age;

    public Person() {

    }

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public char getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "姓名：" + getName() + ",性别：" + getSex() + ",年龄：" + getAge();
    }
}
