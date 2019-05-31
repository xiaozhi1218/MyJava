package oop.basic.day06.exer;

/**
 * @author chenyongzhi
 * @date 2019/5/16 11:39
 */
public class AccountTest {

    public static void main(String[] args) {

        Account acct1 = new Account();
        Account acct2 = new Account("jkl123", 3000);

        Account.setInterestRate(0.012);
        Account.setMinMoney(100);

        System.out.println(acct1);
        System.out.println(acct2);

        System.out.println(acct1.getInterestRate());
        //System.out.println(Account.getInterestRate());
        System.out.println(acct2.getMinMoney());
        //System.out.println(Account.getMinMoney());
    }
}
