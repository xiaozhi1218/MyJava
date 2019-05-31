package basic.exer1;

/**
 * @author chenyongzhi
 * @Description 8.打印:
 * 1
 * 12
 * 123
 * 1234
 * 12345
 * @date 2019/5/4 14:48
 */
public class Test08 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {//i控制行数
            for (int j = 1; j <= i; j++) {//j控制每列输出
                System.out.print(j);//内层循环一次，依次输出j,此时不换行
            }
            System.out.println();//外层循环一次换行
        }
    }
}
