package com.hxzy.entity;

import com.hxzy.service.CallService;
import com.hxzy.service.SendService;

import java.io.Serializable;

/**
 * @author chenyongzhi
 * @create 2019/6/3 15:31
 */
public class TalkPackage extends ServicePackage
        implements CallService, SendService, Serializable {

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

    @Override
    public void showInfo() {
        System.out.println("话唠套餐：通话时长为：" + this.getTalkTime()
                + "分钟/月,短信条数为：" + this.getSmsCount()
                + "条/月,资费为：" + this.getPrice() + "元/月");
    }

    @Override
    public int call(int minCount, MobileCard card) {
        //TODO:implement
        return 0;
    }

    @Override
    public int send(int count, MobileCard card) {
        //TODO:implement
        return 0;
    }
}
