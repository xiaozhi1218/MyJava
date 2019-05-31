package basic.exer2;

/**
 * @author chenyongzhi
 * @Description
 * @date 2019/5/4 10:42
 */
public class Demo12 {
    public static void main(String[] args) {
      /*  for (int i = 1; i <= 6; i++) {
            System.out.print('*');
        }

        System.out.println("\n");

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 6; j++) {
                System.out.print('*');
            }
            System.out.println("");
        }
        System.out.println();

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();*/

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print("-");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("-");
            }
            for (int k = 7; k >= 2 * i - 1; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
