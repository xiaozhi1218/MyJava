package oop.basic.day04.exer1;

/**
 * @author chenyongzhi
 * @date 2019/5/13 9:57
 */
public class Student extends Person {

    private long number;
    private int math;
    private int english;
    private int computer;

    public Student() {

    }

    public Student(String name, char sex, int age, long number, int math, int english, int computer) {
        super(name, sex, age);
        this.number = number;
        this.math = math;
        this.english = english;
        this.computer = computer;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getComputer() {
        return computer;
    }

    public void setComputer(int computer) {
        this.computer = computer;
    }

    public double aver() {
        return (getComputer() + getEnglish() + getMath()) / 3.0;
    }

    public int max() {
        int max = (getComputer() > getMath()) ? getComputer() : getMath();
        return (getEnglish() > max) ? getEnglish() : max;
    }

    public int min() {
        int min = (getComputer() > getMath()) ? getMath() : getComputer();
        return (getMath() > min) ? min : getMath();
    }

    public String toString() {
        return super.toString() + ",学号：" + getNumber() + ",平均分为：" + aver() + ",最高分为：" + max() + ",最低分为：" + min();
    }
}
