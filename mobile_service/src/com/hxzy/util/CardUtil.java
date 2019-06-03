package com.hxzy.util;

import com.hxzy.entity.*;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author chenyongzhi
 * @create 2019/6/3 16:16
 */
public class CardUtil implements Serializable {

    private static Map<String, MobileCard> cards = new HashMap<>();

    private static Map<String, List<ConsumInfo>> consumeInfos = new HashMap<>();

    //static Map<Integer, Scene> sceneMap = new HashMap<>();

    public static File file = new File("data.dat");

    /**
     * 保存信息
     */
    public static void saveData() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(cards);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取信息
     */
    public static void loadData() {
        if (file.length() != 0) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                cards = (Map<String, MobileCard>) ois.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 初始化用户信息
     */
    //
    public static void initScene() {

    }

    //登录验证
    public static boolean isExistCard(String number, String passWord) {

        if (cards.containsKey(number) && (cards.get(number).getPassWord().equals(passWord))) {
            return true;
        }
        System.out.println("登录失败！");
        return false;
    }

    //花费充值确认
    public static boolean isExistCard(String number) {
        Set<String> numbers = cards.keySet();
        Iterator<String> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals(number)) {
                return true;
            }
        }
        return false;
    }

    //创建套餐
    public static ServicePackage createPackage(int packID) {
        ServicePackage servicePackage = null;
        switch (packID) {
            case 1:
                servicePackage = new TalkPackage();
                break;
            case 2:
                servicePackage = new NetPackage();
                break;
            case 3:
                servicePackage = new SuperPackage();
                break;
            default:
                break;
        }
        return servicePackage;
    }

    //生成随机号码
    public static String createNumber() {
        Random random = new Random();
        int temp = (int) ((Math.random() * 9 + 1) * 10000000);
        String number = "139" + temp;
        return number;
    }

    //生成指定个数的卡号
    public static String[] getNewNumbers(int count) {
        String[] strings = new String[count];
        for (int i = 0; i < count; ) {
            if (isExistCard(createNumber())) {
                continue;
            } else {
                strings[i] = createNumber();
                i++;
            }
        }
        return strings;
    }

    //注册新卡
    public static void addCard(MobileCard card) {
        cards.put(card.getCardNumber(), card);
    }

    //删除手机卡， 退网
    public static void delCard(String number) {
        if (cards.containsKey(number)) {
            cards.remove(number);
            System.out.println("卡号" + number + "办理退网成功！");
            System.out.println("谢谢使用");
        } else {
            System.out.println("手机号码输入有误！");
        }
    }

    //套餐剩余查询
    public static void showRemainDetail(String number) {
        MobileCard card = cards.get(number);
        int remainTalkTime, remainSmsCount, remainFlow;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("您的卡号是" + number + ",套餐内剩余: \n");
        ServicePackage servicePackage = card.getSetPackage();

        if (servicePackage instanceof NetPackage) {
            NetPackage netPackage = (NetPackage) servicePackage;
            remainFlow = netPackage.getFlow() > card.getRealFlow() ? netPackage.getFlow() - card.getRealFlow() : 0;
            stringBuffer.append("上网流量：" + (remainFlow / 1024) + "GB");
        } else if (servicePackage instanceof TalkPackage) {
            TalkPackage talkPackage = (TalkPackage) servicePackage;
            remainTalkTime = talkPackage.getTalkTime() > card.getRealTalkTime() ? talkPackage.getTalkTime() - card.getRealTalkTime() : 0;
            stringBuffer.append("通话时长：" + remainTalkTime + "分钟\n");

            remainSmsCount = talkPackage.getSmsCount() > card.getRealSMSCount() ? talkPackage.getSmsCount() - card.getRealSMSCount() : 0;
            stringBuffer.append("短信条数：" + remainSmsCount + "条");
        } else {
            SuperPackage superPackage = (SuperPackage) servicePackage;

            remainTalkTime = superPackage.getTalkTime() > card.getRealTalkTime() ? superPackage.getTalkTime() - card.getRealTalkTime() : 0;
            stringBuffer.append("通话时长：" + remainTalkTime + "分钟\n");

            remainSmsCount = superPackage.getSmsCount() > card.getRealSMSCount() ? superPackage.getSmsCount() - card.getRealSMSCount() : 0;
            stringBuffer.append("短信条数：" + remainSmsCount + "条\n");

            remainFlow = superPackage.getFlow() > card.getRealFlow() ? superPackage.getFlow() - card.getRealFlow() : 0;
            stringBuffer.append("上网流量：" + remainFlow / 1024 + "GB");
        }
        System.out.println(stringBuffer);
    }

    //本月套餐账单查询
    public static void showAmountDetail(String number) {
        StringBuffer stringBuffer = new StringBuffer();
        MobileCard mobileCard = cards.get(number);
        stringBuffer.append("***********************************\n");
        stringBuffer.append("您的卡号：" + mobileCard.getCardNumber() + "\n当月账单:\n");
        stringBuffer.append("您的套餐：" + mobileCard.getSetPackage().getName() + "\n");
        stringBuffer.append("套餐资费：" + mobileCard.getSetPackage().getPrice() + "元\n");
        stringBuffer.append("合计:" + dataFormat((mobileCard.getConsumAmount() + mobileCard.getSetPackage().getPrice())) + "元\n");
        stringBuffer.append("账号余额:" + dataFormat(mobileCard.getMoney()) + "元");
        System.out.println(stringBuffer);
    }

    /**
     * double类型小数取最后一位
     *
     * @param data
     * @return
     */
    public static String dataFormat(double data) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        return decimalFormat.format(data);
    }

    /**
     * 保存消费信息
     *
     * @param number
     * @param info
     */
    public static void addConsumInfo(String number, ConsumInfo info) {
        if (consumeInfos.containsKey(number)) {
            consumeInfos.get(number).add(info);
        } else {
            List<ConsumInfo> list = new ArrayList<>();
            list.add(info);
            consumeInfos.put(number, list);
        }
    }

    public static void useSoso(String number) {

    }

    /**
     * 资费说明
     */
    public static void showDescription() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("资费说明.txt"));
            String data;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 套餐变更
     *
     * @param number
     * @param packNum
     */
    public static void changingPack(String number, int packNum) {

        switch (packNum) {
            case 1:
                if (cards.get(number).getSetPackage() instanceof TalkPackage) {
                    System.out.println("您已是该套餐用户，无法更换");
                } else {
                    if (cards.get(number).getMoney() < cards.get(number).getSetPackage().getPrice()) {
                        System.out.println("您的余额不足以支付本月套餐资费，请充值后再办理.");
                    } else {
                        cards.get(number).setRealTalkTime(0);
                        cards.get(number).setRealSMSCount(0);
                        cards.get(number).setRealFlow(0);
                        cards.get(number).setSetPackage(createPackage(packNum));
                        //减去月资费
                        cards.get(number).setMoney(cards.get(number).getMoney() - cards.get(number).getSetPackage().getPrice());
                        System.out.println("套餐变更成功！");
                        createPackage(packNum).showInfo();
                    }
                }
                break;
            case 2:
                if (cards.get(number).getSetPackage() instanceof NetPackage) {
                    System.out.println("您已经是该套餐用户，无需换套餐。");
                } else {
                    if (cards.get(number).getMoney() < cards.get(number).getSetPackage().getPrice()) {
                        System.out.println("您的余额不足以支付本月套餐资费，请充值后再办理。");
                    } else {
                        cards.get(number).setRealTalkTime(0);
                        cards.get(number).setRealSMSCount(0);
                        cards.get(number).setRealFlow(0);
                        cards.get(number).setSetPackage(createPackage(packNum));
                        //减去月资费
                        cards.get(number).setMoney(cards.get(number).getMoney() - cards.get(number).getSetPackage().getPrice());
                        System.out.println("套餐变更成功！");
                        createPackage(packNum).showInfo();
                    }
                }
                break;
            case 3:
                if (cards.get(number).getSetPackage() instanceof SuperPackage) {
                    System.out.println("您已经是该套餐用户，无需换套餐。");
                } else {
                    if (cards.get(number).getMoney() < cards.get(number).getSetPackage().getPrice()) {
                        System.out.println("您的余额不足以支付本月套餐资费，请充值后再办理。");
                    } else {
                        cards.get(number).setRealTalkTime(0);
                        cards.get(number).setRealSMSCount(0);
                        cards.get(number).setRealFlow(0);
                        cards.get(number).setSetPackage(createPackage(packNum));
                        //减去月资费
                        cards.get(number).setMoney(cards.get(number).getMoney() - cards.get(number).getSetPackage().getPrice());
                        System.out.println("套餐变更成功！");
                        createPackage(packNum).showInfo();
                    }
                }
                break;
        }
    }

    /**
     * 打印消费清单
     *
     * @param number
     */
    public static void printConsumeInfo(String number) {
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("test.txt"));
            Set<String> numbers = consumeInfos.keySet();
            Iterator<String> iterator = numbers.iterator();
            List<ConsumInfo> infos = new ArrayList<>();
            infos = consumeInfos.get(number);
            boolean isExist = false;
            while (iterator.hasNext()) {
                String numberKey = iterator.next();
                if (number.equals(numberKey)) {
                    isExist = true;
                }
            }
            if (isExist) {
                StringBuffer stringBuffer = new StringBuffer("********" + number + "消费记录********\n");
                stringBuffer.append("序号\t类型\t数据（通话（分钟）/上网（MB）/短信（条））\n");
                for (int i = 0; i < infos.size(); i++) {
                    ConsumInfo info = infos.get(i);
                    System.out.println((i + 1) + ".\t" + info.getType() + "\t" + info.getConsumData() + "\n");
                    stringBuffer.append((i + 1) + ".\t" + info.getType() + "\t" + info.getConsumData() + "\n");
                }
                br.write(stringBuffer.toString());
                br.flush();
                System.out.println("消息打印完毕！");
            } else {
                System.out.println("对不起，不存在此号码的消费记录！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 花费充值
     * @param number
     * @param money
     */
    public static void chargeMoney(String number, double money) {
        cards.get(number).setMoney(cards.get(number).getMoney() + money);
    }

    public static MobileCard getCard(String number) {
        MobileCard card = cards.get(number);
        return card;
    }
}
