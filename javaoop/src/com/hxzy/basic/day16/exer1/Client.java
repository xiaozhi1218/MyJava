package com.hxzy.basic.day16.exer1;

import org.junit.Test;

/**
 * @author chenyongzhi
 * @date 2019/5/15 10:47
 */
public class Client {

    @Test
    public void testInterface() {

        Mother mother = new Mother();
        mother.narrate(new Book());
        mother.narrate(new Newspaper());
    }


}
