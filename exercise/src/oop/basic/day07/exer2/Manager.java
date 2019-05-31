package oop.basic.day07.exer2;

/**
 * 对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
 * @author chenyongzhi
 * @create 2019/5/19 21:09
 */
public class Manager extends Employee {

    private double bonus;

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("管理员工");
    }
}
