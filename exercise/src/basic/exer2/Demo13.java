package basic.exer2;

/**
 * @author chenyongzhi
 * @Description
 * @date 2019/5/4 12:59
 */
public class Demo13 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + " ");
            }
            System.out.println();
        }
    }
}
