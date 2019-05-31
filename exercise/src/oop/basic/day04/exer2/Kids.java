package oop.basic.day04.exer2;

/**
 * @author chenyongzhi
 * @date 2019/5/13 11:49
 */
public class Kids extends ManKind{

    private int yearsOld;

    public Kids() {

    }

    public Kids(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge() {
        System.out.println("I am " + yearsOld + " years old.");
    }

    @Override
    public void employeed() {
        System.out.println("Kids should study and no job.");
    }


}
