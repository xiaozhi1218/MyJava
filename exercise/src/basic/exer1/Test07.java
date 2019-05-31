package basic.exer1;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @Description 7.根据条件确定公司是否已经为司机投保
 * 如果司机满足下列条件之一，公司则为他们投保：
 * (1) 司机已婚。
 * (2) 司机为30岁以上的未婚男性。
 * (3) 司机为25岁以上的未婚女性。
 * 如果以上条件一个也不满足，则公司不为司机投保。
 * 请编写一个程序，根据用户输入司机的婚姻状况、性别和年龄，判定该司机是否已经投保。
 * (思路：婚姻状况：“y”表示已婚，“n”表示未婚;性别：“m”表男性，“f”表女性;使用多重if结构或者嵌套if结构编写程序)
 * @date 2019/5/4 14:34
 */
public class Test07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入个人信息：");
        System.out.println("婚姻状况：(y/n)");
        String isMarriage = scanner.next();
        System.out.println("性别：(m/f)");
        String gender = scanner.next();
        System.out.println("年龄：");
        int age = scanner.nextInt();
        if (isMarriage.equals("y")) {
            System.out.println("已投保");
        } else if (age > 30 && isMarriage.equals("n") && gender.equals("m")) {
            System.out.println("已投保");
        } else if (age > 25 && gender.equals("f") && gender.equals("f")) {
            System.out.println("已投保");
        } else {
            System.out.println("没有投保");
        }
    }
}
