package com.hxzy.entity;

import com.hxzy.service.NetService;

import java.io.Serializable;

/**
 * 网虫套餐
 * @author chenyongzhi
 * @create 2019/6/3 15:46
 */
public class NetPackage extends ServicePackage
        implements NetService, Serializable {

    private int flow = 5120;//流量

    private double price = 68;

    private String name = "网虫套餐";

    public NetPackage() {
        super(68, "网虫套餐");
    }

    public NetPackage(int flow, double price) {
        super(68, "网虫套餐");
        this.flow = 3072;
        this.price = 68;
    }

    public NetPackage(int flow, double price, String name) {
        super(68, "网虫套餐");
        this.flow = flow;
        this.price = price;
        this.name = name;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    /**
     * 流量使用情况
     *
     * @param flow
     * @param card
     * @return 流量使用
     */
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
                System.out.println("流量已经使用" + i + "MB，您的余额不足，请充值后使用！");
                break;
            }
        }
        return temp;
    }

    @Override
    public void showInfo() {
        System.out.println("网虫套餐：上网流量为：" + this.getFlow()
                + "MB/月," + "资费为：" + this.getPrice() + "元/月");
    }
}
