package basic.exer2;

/**
 * @author chenyongzhi
 * @Description
 * @date 2019/5/4 10:24
 */
public class Demo10 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 4 == 0) {
                break;
            }
            System.out.print(i);
        }
        System.out.println("\n");
       //************************

        label:
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j % 4 == 0) {
                    continue label;
                }
                System.out.print(j);
            }
        }

    }
}
