package oop.senior.day19_reflection.exer2;

import java.io.Serializable;

/**
 * @author chenyongzhi
 * @create 2019/6/3 10:01
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }

}
