package com.hxzy.basic.day15.exer2;

/**
 * @author chenyongzhi
 * @date 2019/5/14 10:05
 */
public abstract class Employee {

    private String name;
    private int id;
    private int salary;

    public Employee() {

    }

    public Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();
}
