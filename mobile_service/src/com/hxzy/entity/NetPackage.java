package com.hxzy.entity;

import com.hxzy.service.NetService;

import java.io.Serializable;

/**
 * @author chenyongzhi
 * @create 2019/6/3 15:46
 */
public class NetPackage extends ServicePackage
        implements NetService, Serializable {

    private int flow = 3072;

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
     * @param flow
     * @param card
     * @return 流量使用
     */
    @Override
    public int netPlay(int flow, MobileCard card) {
        //TODO:netPlay
        return 0;
    }

    @Override
    public void showInfo() {
        System.out.println("网虫套餐：上网流量为：" + this.getFlow()
                + "MB/月," + "资费为：" + this.getPrice() + "元/月");
    }
}
