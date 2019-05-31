package com.hxzy.basic.day17;


/**
 * @author chenyongzhi
 * @date 2019/5/16 11:17
 */
public class InnerClassTest {
    public static void main(String[] args) {

        //静态内部类
        Person.Dog dog = new Person.Dog();
        dog.show();

        //非静态内部类
        Person p= new Person();
        Person.Bird bird = p.new Bird();
        bird.sing();

        System.out.println();

        bird.display("麻雀");
    }
}

class Person {

    String name = "cyz";
    int age;

    public void eat() {
        System.out.println("吃饭");
    }

    static class Dog {
        String name;
        int age;

        public void show() {
            System.out.println("狗");
            //eat();
        }
    }

    class Bird {

        String name;

        public Bird() {

        }

        public void sing() {
            System.out.println("我是一只鸟");
            Person.this.eat();
            System.out.println(age);
        }

        public void display(String name) {
            System.out.println(name);//方法的形参
            System.out.println(this.name);//内部类属性
            System.out.println(Person.this.name);//外部类属性
        }
    }
}
