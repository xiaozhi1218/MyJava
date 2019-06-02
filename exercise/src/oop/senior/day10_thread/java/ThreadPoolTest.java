package oop.senior.day10_thread.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式四：使用线程池
 * <p>
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 * corePoolSize：核心池的大小
 * maximumPoolSize：最大线程数
 * keepAliveTime：线程没有任务时最多保持多长时间后会终止
 * <p>
 * <p>
 * 面试题：创建多线程有几种方式？四种！
 *
 * @author chenyongzhi
 * @date 2019/5/29 11:06
 */
class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread2 implements Runnable {

    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        NumberThread1 numberThread1 = new NumberThread1();
        NumberThread2 numberThread2 = new NumberThread2();

        service.execute(numberThread1);
        service.execute(numberThread2);



    }
}
