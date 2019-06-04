package com.hxzy.entity;

/**
 * 用户消费信息
 * @author chenyongzhi
 * @create 2019/6/3 15:55
 */
public class ConsumInfo {

    private String cardNumber;//卡号

    private String type;//消费类型

    private int consumData;//消费数据

    public ConsumInfo(String cardNumber, String type, int consumData) {
        this.cardNumber = cardNumber;
        this.type = type;
        this.consumData = consumData;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getConsumData() {
        return consumData;
    }

    public void setConsumData(int consumData) {
        this.consumData = consumData;
    }
}
