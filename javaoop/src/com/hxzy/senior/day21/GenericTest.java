package com.hxzy.senior.day21;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author chenyongzhi
 * @date 2019/5/22 15:19
 */
public class GenericTest {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(123);
        list.add(456);
        list.add(789);

        /*for (Integer i : list) {
            System.out.println(i);
        }*/

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
