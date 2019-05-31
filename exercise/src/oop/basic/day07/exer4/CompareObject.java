package oop.basic.day07.exer4;

/**
 * interface CompareObject{
 * 	public int compareTo(Object o);
 * 	若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
 *  }
 * @author chenyongzhi
 * @create 2019/5/19 22:07
 */
public interface CompareObject {

    public abstract int compareTo(Object o);
}
