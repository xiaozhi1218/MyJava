package test.entity;

import java.io.Serializable;


public class MobileCard implements Serializable {

    private String cardNumber;

    private String userName;

    private String passWord;

    private double consumAmount;

    private double money;

    private int realTalkTime;

    private int realSMSCount;

    private int realFlow;

    private ServicePackage serPackage;

    public String getCardNumber() {
        return cardNumber;
    }

    public MobileCard() {
    }
    /*
    *构造函数（注册）
    *@param 卡号
    *@param 用户名
    *@param 密码
    *@param 余额
    *@param 所属套餐
    */
    public MobileCard(String cardNumber, String userName, String passWord, double money, ServicePackage serPackage) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.passWord = passWord;
        this.money = money;
        this.serPackage = serPackage;
    }

    /*
    * 构造函数（初始化用户信息）
    *@param 卡号
    *@param 用户名
    *@param 密码
    *@param 消费金额
    *@param 余额
    *@param 当月通话时长
    *@param 当月发送短信数量
    *@param 当月上网流量
    *@param 所属套餐
    * */
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

    /*@Override
    public String toString() {
        return "MobileCard{" +
                "serPackage=" + serPackage +
                '}';
    }*/

    /*
    * 显示移动卡信息
    * */
    public void showMeg() {
        System.out.println("\n卡号："+this.getCardNumber()+
                "\n套餐类型:"+this.getSerPackage().getName() +
                "\n用户名："+this.getUserName()+"\n当前余额："+this.getMoney()+"元");
    }

}