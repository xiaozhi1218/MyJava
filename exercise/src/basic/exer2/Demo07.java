package basic.exer2;

import java.util.Scanner;

public class Demo07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int num1 = scanner.nextInt();
        System.out.println("请输入第二个数：");
        int num2 = scanner.nextInt();
        System.out.println("请输入第三个数：");
        int num3 = scanner.nextInt();

        if (num1 > num2) {
            if (num3 > num1) {
                System.out.println(num2 + "," + num1 + "," + num3);
            } else if (num3 < num2) {
                System.out.println(num3 + "," + num2 + "," + num1);
            } else {
                System.out.println(num2 + "," + num3 + "," + num1);
            }
        } else {
            if (num3 < num1) {
                System.out.println(num3+ "," + num1+ "," + num2);
            } else if (num3 > num2) {
                System.out.println(num1+ "," + num2+ "," + num3);
            } else {
                System.out.println(num1+ "," + num3+ "," + num2);
            }
        }
    }
}
