package com.hxzy.basic.day13;

/**
 * @author chenyongzhi
 * @description
 * @date 2019/5/10 14:32
 */
public class ManKind {
    int sex;
    int salary;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void manOrWomen() {
        if (sex == 1) {
            System.out.println("man");
        } else if (sex == 0) {
            System.out.println("women");
        }
    }

    public void employeed() {
        if (salary == 0) {
            System.out.println("no job");
        } else {
            System.out.println("job");
        }
    }
}
