package basic.exer2;

public class Demo01 {
    public static void main(String[] args) {
        int m = 132;
        int n = 123;
        int max = (m > n) ? m : n;
        System.out.println(max);

        n = 132;
        String maxStr = (m > n) ? "m大" : ((m == n) ? "m和n相等" : "n大");
        System.out.println(maxStr);

        int n1 = 12;
        int n2 = 30;
        int n3 = -43;
        int max1 = (n1 > n2) ? n1 : n2;
        int max2 = (max1 > n3) ? max1 : n3;
        System.out.println(max2);
    }
}
