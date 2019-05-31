package oop.basic.day01.exer2;

/**
 * @author chenyongzhi
 * @description
 * 要求：
 * (1)创建Person类的对象，设置该对象的name、age和sex属性，调用study方法，
 * 输出字符串“studying”，调用showAge()方法显示age值，
 * 调用addAge()方法给对象的age属性值增加2岁。
 * (2)创建第二个对象，执行上述操作，体会同一个类的不同对象之间的关系。
 * @create 2019/5/11 13:19
 */

public class PersonTest {

    public static void main(String[] args) {

        Person p1 = new Person();

        p1.setName("Tom");
        p1.setAge(18);
        p1.setSex(1);
        p1.study();
        p1.showAge();

        p1.addAge(2);
        System.out.println(p1.getName() + "的新年龄为：" + p1.getAge());
    }
}
