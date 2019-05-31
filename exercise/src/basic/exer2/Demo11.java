package basic.exer2;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @Description
 * @date 2019/5/4 10:35
 */
public class Demo11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int positiveNumber = 0;
        int negativeNumber = 0;
        for (;;) {//或者while(true)
            int number = scanner.nextInt();
            if (number > 0) {
                positiveNumber++;
            } else if (number < 0) {
                negativeNumber++;
            } else {
                break;
            }
        }
        System.out.println("正数个数为：" + positiveNumber);
        System.out.println("负数个数为：" + negativeNumber);
    }

}
