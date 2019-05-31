package basic.exer2;

public class Demo04 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("helloworld");
        }
        //System.out.println(i);

        int num = 1;
        for (System.out.print('a'); num <= 3; System.out.print('c'), num++) {
            System.out.print('b');
        }
        System.out.println();
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= 100 ; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                sum = sum + i;
                count++;
            }
        }
        System.out.println(sum);
        System.out.println(count);
    }
}
