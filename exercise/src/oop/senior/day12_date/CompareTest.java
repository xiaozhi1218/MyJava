package oop.senior.day12_date;

import org.junit.Test;

import java.util.Arrays;

/**
 * 一、说明：Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
 * 但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
 * 如何实现？使用两个接口中的任何一个：Comparable 或 Comparator
 * <p>
 * 二、Comparable接口与Comparator的使用的对比：
 * Comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
 * Comparator接口属于临时性的比较。
 *
 * @author chenyongzhi
 * @create 2019/6/18 21:37
 */
public class CompareTest {

    /*
    Comparable接口的使用举例：  自然排序
    1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。
    2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
    3. 重写compareTo(obj)的规则：
        如果当前对象this大于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回负整数，
        如果当前对象this等于形参对象obj，则返回零。
    4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。
       在compareTo(obj)方法中指明如何排序
     */
    @Test
    public void test1() {

        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("microsoftMouse",43);

        Arrays.sort(arr);

        for (Goods goods : arr) {
            System.out.println(goods);
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        //System.out.println(Arrays.toString(arr));
    }
}
