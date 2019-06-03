package com.hxzy.entity;

import java.io.Serializable;

/**
 * @author chenyongzhi
 * @create 2019/6/3 15:31
 */
public class MobileCard implements Serializable {

    private String cardNumber;
    private String userName;
    private String passWord;
    private double consumAmount;
    private double money;
    private int realTalkTime;
    private int realSMSCount;
    private int realFlow;
    private ServicePackage setPackage;

    /**
     * 用户注册
     * @param cardNumber
     * @param userName
     * @param passWord
     * @param money
     * @param setPackage
     */
    public MobileCard(String cardNumber, String userName, String passWord, double money, ServicePackage setPackage) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.passWord = passWord;
        this.money = money;
        this.setPackage = setPackage;
    }

    /**
     * 用户初始化信息
     * @param cardNumber
     * @param userName
     * @param passWord
     * @param consumAmount
     * @param money
     * @param realTalkTime
     * @param realSMSCount
     * @param realFlow
     * @param setPackage
     */
    public MobileCard(String cardNumber, String userName, String passWord, double consumAmount, double money, int realTalkTime, int realSMSCount, int realFlow, ServicePackage setPackage) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.passWord = passWord;
        this.consumAmount = consumAmount;
        this.money = money;
        this.realTalkTime = realTalkTime;
        this.realSMSCount = realSMSCount;
        this.realFlow = realFlow;
        this.setPackage = setPackage;
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

    public ServicePackage getSetPackage() {
        return setPackage;
    }

    public void setSetPackage(ServicePackage setPackage) {
        this.setPackage = setPackage;
    }

    @Override
    public String toString() {
        return "MobileCard{" + "setPackage = " + setPackage + "}";
    }

    public void showMeg() {
        System.out.println("\n卡号：" + this.getCardNumber() + "\n套餐类型：" + this.getSetPackage());
    }

}
