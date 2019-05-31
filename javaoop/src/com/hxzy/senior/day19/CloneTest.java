package com.hxzy.senior.day19;

/**
 * @author chenyongzhi
 * @date 2019/5/20 12:47
 */
public class CloneTest {

    public static void main(String[] args) {

        Animal a1 = new Animal("花花");
        System.out.println("原始对象：" + a1);
        try {
            Animal a2 = (Animal) a1.clone();
            a2.setName("毛毛");
            System.out.println("克隆之后的对象：" + a2);
            System.out.println(a1);
            System.out.println(a2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Animal implements Cloneable {
    private String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

