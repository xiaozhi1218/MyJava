package basic.exer2;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你是否帅：(是/否)");
        String isHandsome = scanner.next();
        if (isHandsome.equals("是")) {
            System.out.println("可以嫁了");
        } else {
            System.out.println("算了吧");
        }
    }
}
