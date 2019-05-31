package oop.basic.day03.exer1;

/**
 * @author chenyongzhi
 * @create 2019/5/11 18:48
 */
public class Boy {

    private String name;
    private int age;

    public Boy() {

    }

    public Boy(String name) {
        this.name = name;
    }

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void marrry(Girl girl) {
        System.out.println("我想娶" + girl.getName());
    }

    public void shout() {
        if (this.age >= 22) {
            System.out.println("可以合法结婚了");
        } else {
            System.out.println("先多谈恋爱~~");
        }
    }
}
