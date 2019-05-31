package basic.exer2;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个正整数：");
        int m = scanner.nextInt();
        System.out.println("请输入第二个正整数：");
        int n = scanner.nextInt();

        //获取最大公约数
        int min = (m <= n) ? m : n;
        for (int i = min; i >= 1; i--) {
            if (m % i == 0 && n % i == 0) {
                System.out.println("最大公约数是：" + i);
                break;
            }
        }

        int max = (m >= n) ? m : n;
        for (int i = max; i <= m * n; i++) {
            if (i % m == 0 && i % n == 0) {
                System.out.println("最小公倍数是" + i);
                break;
            }
        }

    }
}
