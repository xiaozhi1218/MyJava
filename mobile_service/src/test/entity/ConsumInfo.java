package test.entity;

public class ConsumInfo {

    private String cardNumber;
    //消费类型
    private String type;

    private int consumData;

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

    public ConsumInfo(String cardNumber, String type, int consumData) {
        this.cardNumber = cardNumber;
        this.type = type;
        this.consumData = consumData;
    }
}