package basic.exer1;

/**
 * @author chenyongzhi
 * @Description 10.打印:
 * 12345
 * 1234
 * 123
 * 12
 * 1
 * @date 2019/5/4 14:54
 */
public class Test10 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {//i控制行数
            for (int j = 1; j <= 6 - i; j++) {//j控制每列输出
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
