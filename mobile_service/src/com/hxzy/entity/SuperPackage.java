package com.hxzy.entity;

import com.hxzy.service.CallService;
import com.hxzy.service.NetService;
import com.hxzy.service.SendService;

import java.io.Serializable;

/**
 * 超人套餐
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
        int temp = minCount;
        for (int i = 0; i < minCount; i++) {
            if (this.talkTime - card.getRealTalkTime() >= 1) {
                card.setRealTalkTime(card.getRealTalkTime() + 1);
            } else if (card.getMoney() >= 0.2) {
                card.setRealTalkTime(card.getRealTalkTime() + 1);
                card.setMoney(card.getMoney() - 0.2);
                card.setConsumAmount(card.getConsumAmount() + 0.2);
            } else {
                temp = i;
                System.out.println("您已通话：" + i + "分钟，您的余额不足，请充值。");
                break;
            }
        }
        return temp;
    }

    @Override
    public int send(int count, MobileCard card) {
        int temp = count;
        for (int i = 0; i < count; i++) {
            /*
            短信充足，使用短信++
             */
            if (this.smsCount - card.getRealSMSCount() >= 1) {
                card.setRealSMSCount(card.getRealSMSCount() + 1);
            }
            /*
            短信不够，剩余余额
             */
            else if (card.getMoney() >= 0.1) {
                card.setRealSMSCount(card.getRealSMSCount() + 1);
                card.setMoney(card.getMoney() - 0.1);
                card.setConsumAmount(card.getConsumAmount() + 0.1);
            }
            /*
            余额不够
             */
            else {
                temp = i;
                System.out.println("您短信已经发送了" + i + "条，您的余额不足，请充值后再使用");
                break;
            }
        }
        return temp;
    }

    @Override
    public int netPlay(int flow, MobileCard card) {
        int temp = flow;
        for (int i = 0; i < flow; i++) {
            //当总流量多余使用流量，使用流量++
            if (this.flow - card.getRealFlow() >= 1) {
                card.setRealFlow(card.getRealFlow() + 1);
            }
            //当流量用超，使用流量++，账号余额--，花销++
            else if (card.getMoney() >= 0.1) {
                card.setRealFlow(card.getRealFlow() + 1);
                card.setMoney(card.getMoney() - 0.1);
                card.setConsumAmount(card.getConsumAmount() + 0.1);
            }
            //当账号没钱时，提示充值
            else {
                temp = i;
                System.out.println("流量已使用" + i + "MB，您的余额不足，请充值后使用！");
                break;
            }
        }
        return temp;
    }
}
