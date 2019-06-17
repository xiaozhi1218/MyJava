package com.hxzy.senior;

public class Example implements Runnable {
    public static void main(String[] args) {
        Example ex1 = new Example();
        Example ex2 = new Example();
        Example ex3 = new Example();
        ex1.run();
        ex2.run();
        ex3.run();
    }
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}