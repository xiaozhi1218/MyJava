package oop.basic.day02.exer1;

/**
 * @author chenyongzhi
 * @create 2019/5/11 16:34
 * 1.编写程序，定义三个重载方法并调用。方法名为mOL。
 * 三个方法分别接收一个int参数、两个int参数、一个字符串参数。
 * 分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
 * 在主类的main ()方法中分别用参数区别调用三个方法。
 * <p>
 * 2.定义三个重载方法max()，
 * 第一个方法求两个int值中的最大值，
 * 第二个方法求两个double值中的最大值，
 * 第三个方法求三个double值中的最大值，
 * 并分别调用三个方法。
 */
public class OverLoadTest {

    public static void main(String[] args) {
        OverLoadTest overLoad = new OverLoadTest();

        overLoad.mOL(10);
        overLoad.mOL("sasdf");
        overLoad.mOL(2,4);

        overLoad.max(2, 1);
        overLoad.max(1.2, 0.7);
        double max = overLoad.max(3.6, 2.7, 2.2);
        System.out.println(max);
    }

    public void mOL(int i) {
        System.out.println(i * i);
    }

    public void mOL(int i, int j) {
        System.out.println(i * j);
    }

    public void mOL(String s) {
        System.out.println(s);
    }

    public int max(int i, int j) {
        return (i > j) ? i : j;
    }

    public double max(double i, double j) {
        return (i > j) ? i : j;
    }

    public double max(double i, double j, double k) {
        double max = (i > j) ? i : j;
        return (max > k) ? max : k;
    }
}
