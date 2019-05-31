package oop.basic.day03.exer2;

/**
 * @author chenyongzhi
 * @create 2019/5/11 17:16
 * 1.创建程序,在其中定义两个类：Person和PersonTest类。定义如下：
 * 用setAge()设置人的合法年龄(0~130)，用getAge()返回人的年龄。
 * <p>
 * 2.练习2：
 * 2.1. 在前面定义的Person类中添加构造器，利用构造器设置所有人的age属性初始值都为18。
 * 2.2. 修改上题中类和构造器，增加name属性,使得每次创建Person对象的同时初始化对象的age属性值和name属性值。
 */
public class Person {

    private int age;
    private String name;

    public Person() {
        age = 18;
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 130) {
            System.out.println("非法");
            return;
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
