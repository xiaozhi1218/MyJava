package basic.exer1;

import java.util.Scanner;

public class Test13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入菱形的层高：");
        int num = scanner.nextInt();
        while (num % 2 == 0) {
            System.out.println("输入层高错误，请重新输入：");
            num = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (Math.abs(i - (num - 1) / 2) + Math.abs(j - (num - 1) / 2) <= (num - 1) / 2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
