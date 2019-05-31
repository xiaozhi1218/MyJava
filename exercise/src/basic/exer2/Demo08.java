package basic.exer2;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @Description
 * @date 2019/5/4 10:04
 */
public class Demo08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入year：");
        int year = scanner.nextInt();
        System.out.println("请输入month：");
        int month = scanner.nextInt();
        System.out.println("请输入day：");
        int day = scanner.nextInt();
        int sumDays = 0;
        switch (month) {
            case 12:
                sumDays += 30;
            case 11:
                sumDays += 31;
            case 10:
                sumDays += 30;
            case 9:
                sumDays += 31;
            case 8:
                sumDays += 31;
            case 7:
                sumDays += 30;
            case 6:
                sumDays += 31;
            case 5:
                sumDays += 30;
            case 4:
                sumDays += 31;
            case 3:
                if (year % 4 == 0 && year % 100 != 00 || year % 400 == 0) {
                    sumDays += 29;
                } else {
                    sumDays += 28;
                }
            case 2:
                sumDays += 31;
            case 1:
                sumDays += day;
        }
        System.out.println(year + "年" + month + "月" + day + "日是当年的第" + sumDays + "天");
    }
}
