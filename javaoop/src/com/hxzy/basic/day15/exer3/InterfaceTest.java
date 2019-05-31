package com.hxzy.basic.day15.exer3;

/**
 * @author chenyongzhi
 * @date 2019/5/14 15:05
 */
public class InterfaceTest {

    public static void main(String[] args) {

        //BasketballPlayer basketballPlayer = new BasketballPlayer();
        Player player = new BasketballPlayer();

        player.swimming();
        player.training();

        Swim swim1 = new CollegeStudent();
        Swim swim2 = (Swim) player;

        swim1.swimming();
        swim2.swimming();
        
    }
}
