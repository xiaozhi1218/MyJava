package oop.basic.day04.exer2;

/**
 * @author chenyongzhi
 * @date 2019/5/13 11:53
 */
public class KidTest {

    public static void main(String[] args) {

        Kids someKids = new Kids(12);

        someKids.printAge();

        someKids.setSalary(0);
        someKids.setSalary(1);

        someKids.employeed();
        someKids.manOrWoman();
    }
}
