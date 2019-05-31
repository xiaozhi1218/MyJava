package oop.basic.day03.exer1;

/**
 * @author chenyongzhi
 * @create 2019/5/11 18:49
 */
public class Girl {

    private String name;
    private int age;

    public Girl() {

    }

    public Girl(String name, int age) {
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

    public void marry(Boy boy) {
        System.out.println("我想嫁给" + boy.getName());
        boy.marrry(this);
    }

    public int compare(Girl girl) {
        return this.age - girl.age;
    }
}
