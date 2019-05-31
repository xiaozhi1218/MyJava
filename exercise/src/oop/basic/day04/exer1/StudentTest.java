package oop.basic.day04.exer1;

/**
 * @author chenyongzhi
 * @date 2019/5/13 10:17
 */
public class StudentTest {

    public static void main(String[] args) {

        Student stu = new Student();
        Student stu1 = new Student("李四", '男', 12, 1231222252, 75, 80, 95);

        stu.setName("张三");
        stu.setAge(20);
        stu.setSex('男');
        stu.setNumber(222222525);
        stu.setComputer(60);
        stu.setEnglish(75);
        stu.setMath(80);

        String stuInfo = stu.toString();
        System.out.println(stuInfo);

        System.out.println(stu1.toString());
    }
}
