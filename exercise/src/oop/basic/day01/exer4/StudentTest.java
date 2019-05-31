package oop.basic.day01.exer4;

/**
 * @author chenyongzhi
 * @create 2019/5/11 15:05
 */
public class StudentTest {
    public static void main(String[] args) {

        Student[] stus = new Student[20];

        for (int i = 0; i < stus.length; i++) {
            stus[i] = new Student();

            stus[i].setNumber(i + 1);

            stus[i].setState((int) (Math.random() * (6 - 1 + 1) + 1));

            stus[i].setScore((int) (Math.random() * (100 - 0 + 1)));
        }

        for (int i = 0; i < stus.length; i++) {
            System.out.println(stus[i].info());
        }

        System.out.println("--------------------------");

        for (int i = 0; i < stus.length; i++) {
            if (stus[i].getState() == 3) {
                System.out.println(stus[i].info());
            }
        }

        System.out.println("--------------------------");

        for (int i = 0; i < stus.length - 1; i++) {
            for (int j = 0; j < stus.length - 1 - i; j++) {
                if (stus[j].getScore() > stus[j + 1].getScore()) {
                    Student temp = stus[j];
                    stus[j] = stus[j + 1];
                    stus[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < stus.length; i++) {
            System.out.println(stus[i].info());
        }
    }
}
