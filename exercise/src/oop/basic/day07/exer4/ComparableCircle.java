package oop.basic.day07.exer4;

/**
 * 定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
 *  * 在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
 * @author chenyongzhi
 * @create 2019/5/19 22:06
 */
public class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle() {
    }

    public ComparableCircle(Double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof CompareObject) {
            ComparableCircle c = (ComparableCircle) o;
            return this.getRadius().compareTo(c.getRadius());
        } else {
            throw new RuntimeException("传入的数据类型不匹配");
        }
    }
}
