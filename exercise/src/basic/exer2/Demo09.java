package basic.exer2;

/**
 * @author chenyongzhi
 * @Description
 * @date 2019/5/4 10:20
 */
public class Demo09 {
    public static void main(String[] args) {
        int num = 1;
        int sum = 0;
        int count = 0;
        do {
            if (num % 2 == 0) {
                System.out.println(num);
                sum += num;
                count++;
            }
            num++;
        } while (num <= 100);
        System.out.println(sum);
        System.out.println(count);
    }
}
