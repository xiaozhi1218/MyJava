package oop.basic.day04.exer3;

/**
 * @author chenyongzhi
 * @date 2019/5/13 12:01
 */
public class Cylinder extends Circle {

    private double length;

    public Cylinder() {
        this.length = 1;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public double findVolume() {
        return super.findArea() * getLength();
    }

    @Override
    public double findArea() {
        return Math.PI * getRadius() * getRadius() * 2 + 2 * Math.PI * getRadius() * getLength();
    }
}
