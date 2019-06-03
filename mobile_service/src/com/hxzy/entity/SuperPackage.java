package com.hxzy.entity;

import com.hxzy.service.CallService;
import com.hxzy.service.NetService;
import com.hxzy.service.SendService;

import java.io.Serializable;

/**
 * @author chenyongzhi
 * @create 2019/6/3 15:54
 */
public class SuperPackage extends ServicePackage
        implements CallService, SendService, NetService, Serializable {

    private int talkTime = 200;

    private int smsCount = 50;

    private int flow = 1024;

    private double price = 78;

    private String name = "超人套餐";

    public SuperPackage() {
        super(78, "超人套餐");
    }

    public SuperPackage(double price, String name, int talkTime, int smsCount, int flow, double price1, String name1) {
        super(78, "超人套餐");
        this.talkTime = 200;
        this.smsCount = 50;
        this.flow = 1024;
        this.price = 78;
        this.name = "超人套餐";
    }

    public SuperPackage(double price, String name, int talkTime, int smsCount, int flow, double price1) {
        super(78, "超人套餐");
        this.talkTime = 200;
        this.smsCount = 50;
        this.flow = 1024;
        this.price = 78;
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

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public void showInfo() {
        System.out.println("超人套餐：通话时长为" + this.getTalkTime() + "分钟/月,"
                + "短信条数为" + this.getSmsCount()
                + "条/月,上网流量为" + this.getFlow()
                + "GB/月,资费" + this.getPrice() + "/月。");
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

    @Override
    public int netPlay(int flow, MobileCard card) {
        //TODO:implement
        return 0;
    }
}
