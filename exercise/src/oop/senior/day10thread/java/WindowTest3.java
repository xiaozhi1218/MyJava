package oop.senior.day10thread.java;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 * <p>
 * 关于同步方法的总结：
 * 1. 同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 * 2. 非静态的同步方法，同步监视器是：this
 *    静态的同步方法，同步监视器是：当前类本身
 *
 * @author chenyongzhi
 * @date 2019/5/28 13:16
 */
class Window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
           show();
        }
    }

    private synchronized void show() {//同步监视器：this
        if (ticket > 0) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":买票，票号为：" + ticket);
            ticket--;
        }
    }
}
public class WindowTest3 {
    public static void main(String[] args) {

        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
