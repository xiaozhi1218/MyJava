package oop.senior.day09thread.exer;

/**
 * @author chenyongzhi
 * @date 2019/5/28 11:37
 */
public class Test {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }).start();
    }
}
