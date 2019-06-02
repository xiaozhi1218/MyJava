package oop.senior.day10_thread.exer;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author chenyongzhi
 * @create 2019/5/28 20:46
 */
public class SingletonTest {

    public static void main(String[] args) {

        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}

class Singleton {
    private Singleton() {

    }

    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
