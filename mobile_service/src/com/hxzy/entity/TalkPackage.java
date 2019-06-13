package com.hxzy.entity;

import com.hxzy.service.CallService;
import com.hxzy.service.SendService;

import java.io.Serializable;

/**
 * 话痨套餐
 *
 * @author chenyongzhi
 * @create 2019/6/3 15:31
 */
public class TalkPackage extends ServicePackage implements CallService, SendService, Serializable {

    private int talkTime = 500;

    private int smsCount = 30;

    private double price = 58;

    private String name = "话唠套餐";

    public TalkPackage() {

        super(58, "话唠套餐");
    }

    public TalkPackage(int talkTime, int smsCount, double price, String name) {
        super(58, "话唠套餐");
        this.talkTime = 500;
        this.smsCount = 30;
        this.price = 58;
        this.name = "话唠套餐";
    }

    public TalkPackage(int talkTime, int smsCount, double price) {
        super(58, "话唠套餐");
        this.talkTime = 500;
        this.smsCount = 30;
        this.price = 58;
    }

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

   /* @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }*/

    public void showInfo() {
        System.out.println("话唠套餐：通话时长为：" + this.getTalkTime()
                + "分钟/月,短信条数为："
                + this.getSmsCount() + "条/月,资费为："
                + this.getPrice() + "元/月");
    }


    public int call(int minCount, MobileCard card) {
        int temp = minCount;
        for (int i = 0; i < minCount; i++) {
            //当套餐总通话时间大于实际通话时间，实际通话时间增加
            if (this.talkTime - card.getRealTalkTime() >= 1) {
                card.setRealTalkTime(card.getRealTalkTime() + 1);
            }
            //如果套餐通话费用完，还剩余额的话，通话时间增加，余额减少，消费增加
            else if (card.getMoney() >= 0.2) {
                card.setRealTalkTime(card.getRealTalkTime() + 1);
                card.setMoney(card.getMoney() - 0.2);
                card.setConsumAmount(card.getConsumAmount() + 0.2);
            }
            //余额不够提示充值
            else {
                temp = i;
                System.out.println("您已通话：" + i + "分钟，您的余额不足，请充值。");
                break;
            }
        }
        return temp;
    }


    public int send(int smsCount, MobileCard card) {
        int temp = smsCount;
        for (int i = 0; i < smsCount; i++) {
            //套餐短信数充足，使用短信条数增加
            if (this.smsCount - card.getRealSMSCount() >= 1) {
                card.setRealSMSCount(card.getRealSMSCount() + 1);
            }
            //短信条数超过套餐条数，实际条数增加，消费增加
            else if (card.getMoney() >= 0.1) {
                card.setRealSMSCount(card.getRealSMSCount() + 1);
                card.setMoney(card.getMoney() - 0.1);
                card.setConsumAmount(card.getConsumAmount() + 0.1);
            }
            //余额不够，提示充值
            else {
                temp = i;
                System.out.println("您短信已经发送了" + i + "条，您的余额不足，请充值后再使用");
            }
        }
        return temp;
    }

}
