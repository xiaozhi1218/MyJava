package com.hxzy.entity;

import java.io.Serializable;

/**
 * 移动电话卡信息
 * @author chenyongzhi
 * @create 2019/6/3 15:31
 */
public class MobileCard implements Serializable {

    private String cardNumber;

    private String userName;

    private String passWord;

    private double consumAmount;//消费金额

    private double money;//余额

    private int realTalkTime;//当月通话时长

    private int realSMSCount;//当月发短信数量

    private int realFlow;//当月上网流量

    private ServicePackage serPackage;//所属套餐

    public MobileCard() {
    }

    /**
     * 用户注册
     *
     * @param cardNumber 卡号
     * @param userName 用户名
     * @param passWord 密码
     * @param money 余额
     * @param serPackage 所属套餐
     */
    public MobileCard(String cardNumber, String userName, String passWord, double money, ServicePackage serPackage) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.passWord = passWord;
        this.money = money;
        this.serPackage = serPackage;
    }

    /**
     * 用户初始化信息
     *
     * @param cardNumber 卡号
     * @param userName 用户名
     * @param passWord 密码
     * @param consumAmount 消费金额
     * @param money 余额
     * @param realTalkTime 当月通话时长
     * @param realSMSCount 当月发短信数量
     * @param realFlow 当月上网流量
     * @param serPackage 所属套餐
     */
    public MobileCard(String cardNumber, String userName, String passWord, double consumAmount, double money, int realTalkTime, int realSMSCount, int realFlow, ServicePackage serPackage) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.passWord = passWord;
        this.consumAmount = consumAmount;
        this.money = money;
        this.realTalkTime = realTalkTime;
        this.realSMSCount = realSMSCount;
        this.realFlow = realFlow;
        this.serPackage = serPackage;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getConsumAmount() {
        return consumAmount;
    }

    public void setConsumAmount(double consumAmount) {
        this.consumAmount = consumAmount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getRealTalkTime() {
        return realTalkTime;
    }

    public void setRealTalkTime(int realTalkTime) {
        this.realTalkTime = realTalkTime;
    }

    public int getRealSMSCount() {
        return realSMSCount;
    }

    public void setRealSMSCount(int realSMSCount) {
        this.realSMSCount = realSMSCount;
    }

    public int getRealFlow() {
        return realFlow;
    }

    public void setRealFlow(int realFlow) {
        this.realFlow = realFlow;
    }

    public ServicePackage getSerPackage() {
        return serPackage;
    }

    public void setSerPackage(ServicePackage serPackage) {
        this.serPackage = serPackage;
    }

    /**
     * 显示电话卡信息
     */
    public void showMeg() {
        System.out.println("\n卡号：" + this.getCardNumber()
                + "\n套餐类型:" + this.getSerPackage().getName()
                + "\n用户名：" + this.getUserName()
                + "\n当前余额：" + this.getMoney() + "元");
    }
}
