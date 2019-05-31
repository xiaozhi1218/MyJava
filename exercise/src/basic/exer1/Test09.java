package basic.exer1;

/**
 * @author chenyongzhi
 * @Description 9.打印:
 * 54321
 * 4321
 * 321
 * 21
 * 1
 * @date 2019/5/4 14:50
 */
public class Test09 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {//i控制行数
            for (int j = 5; j >= i; j--) {//j控制每列输出
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
