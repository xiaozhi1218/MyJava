package com.hxzy.entity;

import java.io.Serializable;

/**
 * 服务套餐
 * @author chenyongzhi
 * @create 2019/6/3 15:27
 */
public class ServicePackage implements Serializable {

    private double price;

    private String name;

    public ServicePackage() {
    }

    public ServicePackage(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showInfo() {
        //TODO:implement
    }
}
