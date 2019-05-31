package oop.basic.day03.exer1;

/**
 * @author chenyongzhi
 * @create 2019/5/11 18:49
 */
public class BoyGirlTest {
    public static void main(String[] args) {

        Boy boy = new Boy("罗密欧", 21);
        boy.shout();

        Girl girl = new Girl("朱丽叶", 18);
        girl.marry(boy);

        Girl girl1 = new Girl("祝英台", 17);
        int compare = girl1.compare(girl);
        if (compare > 0) {
            System.out.println(girl1.getName() + "大");
        } else if (compare < 0) {
            System.out.println(girl.getName() + "大");
        } else {
            System.out.println("一样大");
        }
    }
}
