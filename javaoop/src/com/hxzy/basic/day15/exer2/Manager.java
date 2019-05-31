package com.hxzy.basic.day15.exer2;

/**
 * @author chenyongzhi
 * @date 2019/5/14 10:08
 */
public class Manager extends Employee {

    private int bonus;

    public Manager(int bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int id, int salary, int bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("manage work");
    }
}
