package com.hxzy.util;

import com.hxzy.entity.ConsumInfo;
import com.hxzy.entity.MobileCard;

import java.util.List;
import java.util.Map;

/**
 * @author chenyongzhi
 * @create 2019/6/3 16:16
 */
public class CardUtil {

    public Map<String, MobileCard> cards;
    public Map<String, List<ConsumInfo>> consumeInfos;

    public void initScene() {

    }

    public boolean isExistCard(String number, String passWord) {
        return false;
    }

    public boolean isExistCard(String number) {
        return false;
    }

    public String[] getNewNumbers(int count) {
        return new String[]{"1","2"};
    }

    public void addCard(MobileCard card) {

    }

    public void delCard(String number) {

    }

    public void showRemainDetail(String number) {

    }

    public void showAmountDetail(String number) {

    }

    public void addConsumeInfo(String number, ConsumInfo info) {

    }

    public void useSoso(String number) {

    }

    public void showDescription() {

    }

    public void changingPack(String number, String packNum) {

    }

    public void printConsumeInfo(String number) {

    }

    public void chargeMoney(String number, double money) {

    }


}
