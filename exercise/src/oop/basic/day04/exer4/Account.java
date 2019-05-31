package oop.basic.day04.exer4;

/**
 * @author chenyongzhi
 * @date 2019/5/13 14:46
 */
public class Account {

    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest() {
        return annualInterestRate / 12;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return;
        }
        System.out.println("余额不足");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
