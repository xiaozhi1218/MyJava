package com.hxzy.senior.day19;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author chenyongzhi
 * @date 2019/5/20 10:18
 */
public class People implements Comparable<People> {

    private String name;
    private int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
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

    /*@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof People) {
            People people = (People) obj;
            return this.age == people.age && this.name.equals(people.name);
        } else {
            return false;
        }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age &&
                Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(People o) {
        int result = name.compareTo(o.name);
        if (result == 0) {
            return age - o.age;
        }
        return result;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        People p1 = new People("abc", 22);
        People p2 = new People("abbbb", 28);
        People p3 = new People("aaabcd", 23);
        People p4 = new People("bcd", 25);
        People p5 = new People("bcd", 23);

        People[] p = new People[]{p1, p2, p3, p4, p5};
        Arrays.sort(p);

        for (People people : p) {
            System.out.println(people);
        }
    }
}

