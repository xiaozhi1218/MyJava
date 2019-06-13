package com.hxzy.util;

import com.hxzy.entity.*;
import com.hxzy.service.CallService;
import com.hxzy.service.SendService;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * 操作工具类
 *
 * @author chenyongzhi
 * @create 2019/6/3 16:16
 */
public class CardUtil implements Serializable {
    private static Map<String, MobileCard> cards = new HashMap<>();
    private static Map<String, List<ConsumInfo>> consumInfos = new HashMap<>();
    static Map<Integer, Scene> sceneMap = new HashMap<>();

    static File file = new File("mobile_service\\src\\data.dat");

    static Scene scene1 = new Scene("通话", 100, "拨打电话向好友诉苦，通话100分钟");
    static Scene scene2 = new Scene("通话", 20, "跟房东推辞房租，通话20分钟");
    static Scene scene4 = new Scene("短信", 10, "向父母索要生活费，发送短信10条");
    static Scene scene3 = new Scene("短信", 100, "和女朋友吵架，发送短信100条");
    static Scene scene5 = new Scene("上网", 2 * 1024, "晚上躺被窝里追剧，使用流量2GB");
    static Scene scene6 = new Scene("上网", 500, "和室友用热点在电脑上吃鸡，使用流量500MB");


    /**
     * 保存信息
     */
    public static void saveData() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(file));
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
                ObjectInput oi = new ObjectInputStream(
                        new FileInputStream(file));
                cards = (Map<String, MobileCard>) oi.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 用户使用场景初始化
     */
    public static void initScene() {
        MobileCard c1 = new MobileCard("13912312312", "gz", "123", 0, 200, 0, 0, 0, new TalkPackage());
        MobileCard c2 = new MobileCard("13932132132", "mf", "123", 0, 160, 0, 0, 0, new NetPackage());
        MobileCard c3 = new MobileCard("13923323323", "zgw", "123", 0, 300, 0, 0, 0, new SuperPackage());

        cards.put("13912312312", c1);
        cards.put("13932132132", c2);
        cards.put("13911111111", c3);

        ConsumInfo info = new ConsumInfo("12345678910", "电话", 0);

        List<ConsumInfo> list = new ArrayList<>();
        list.add(info);
        consumInfos.put(info.getCardNumber(), list);

    }

    /**
     * 登录验证
     *
     * @param number   移动卡号
     * @param passWord 用户密码
     * @return boolean
     */
    public static boolean isExistCard(String number, String passWord) {
        if (cards.containsKey(number) && (cards.get(number).getPassWord().equals(passWord))) {
            return true;
        } else {
            System.out.println("登录失败!");
            return false;
        }
    }

    /**
     * 话费充值认证
     *
     * @param number 卡号
     * @return boolean
     */
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

    /**
     * 创建套餐
     *
     * @param packID 套餐编号
     * @return 指定套餐
     */
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


    /**
     * 生成随机卡号
     *
     * @return 卡号
     */
    public static String createNumber() {
        int temp = (int) ((Math.random() * 9 + 1) * 10000000);
        return "139" + temp;
    }

    /**
     * 生成指定个数卡号的字符串数组
     *
     * @param count 卡号位数
     * @return 卡号列表
     */
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

    /**
     * 注册新卡
     *
     * @param card 移动卡
     */
    public static void addCard(MobileCard card) {
        cards.put(card.getCardNumber(), card);
    }

    /**
     * 删除手机卡，退网
     *
     * @param number 移动卡号
     */
    public static void delCard(String number) {
        if (cards.containsKey(number)) {
            cards.remove(number);
            System.out.println("卡号" + number + "办理退网成功！");
            System.out.println("谢谢使用！");
        } else {
            System.out.println("手机号码输入有误！");
        }

    }

    /**
     * 套餐剩余信息查询
     *
     * @param number 移动卡号
     */
    public static void showRemainDetail(String number) {
        MobileCard card = cards.get(number);
        int remainTalkTime;
        int remainSmsCount;
        int remainFlow;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("您的卡号是" + number + ",套餐内剩余：\n");
        ServicePackage servicePackage = card.getSerPackage();
        if (servicePackage instanceof NetPackage) {
            //向下转型
            NetPackage netPackage = (NetPackage) servicePackage;
            remainFlow = netPackage.getFlow() > card.getRealFlow() ?
                    netPackage.getFlow() - card.getRealFlow() : 0;
            stringBuffer.append("上网流量：" + (remainFlow / 1024) + "GB");
        } else if (servicePackage instanceof TalkPackage) {
            //向下转型
            TalkPackage talkPackage = (TalkPackage) servicePackage;
            remainTalkTime = talkPackage.getTalkTime() > card.getRealTalkTime() ?
                    talkPackage.getTalkTime() - card.getRealTalkTime() : 0;
            stringBuffer.append("通话时长：" + remainTalkTime + "分钟\n");

            remainSmsCount = talkPackage.getSmsCount() > card.getRealSMSCount() ?
                    talkPackage.getSmsCount() - card.getRealSMSCount() : 0;
            stringBuffer.append("短信条数：" + remainSmsCount + "条");

        } else {
            //向下转型
            SuperPackage superPackage = (SuperPackage) servicePackage;

            remainTalkTime = superPackage.getTalkTime() > card.getRealTalkTime() ?
                    superPackage.getTalkTime() - card.getRealTalkTime() : 0;
            stringBuffer.append("通话时长：" + remainTalkTime + "分钟\n");

            remainSmsCount = superPackage.getSmsCount() > card.getRealSMSCount() ?
                    superPackage.getSmsCount() - card.getRealSMSCount() : 0;
            stringBuffer.append("短信条数：" + remainSmsCount + "条\n");

            remainFlow = superPackage.getFlow() > card.getRealFlow() ?
                    superPackage.getFlow() - card.getRealFlow() : 0;
            stringBuffer.append("上网流量：" + remainFlow / 1024 + "GB");
        }
        System.out.println(stringBuffer);
    }

    /**
     * 套餐本月账单查询
     *
     * @param number 移动卡号
     */
    public static void showAmountDetail(String number) {
        StringBuffer stringBuffer = new StringBuffer();
        MobileCard mobileCard = cards.get(number);
        stringBuffer.append("***********************************\n");
        stringBuffer.append("您的卡号：" + mobileCard.getCardNumber() + "\n当月账单:\n");
        stringBuffer.append("您的套餐：" + mobileCard.getSerPackage().getName() + "\n");
        stringBuffer.append("套餐资费：" + mobileCard.getSerPackage().getPrice() + "元\n");
        stringBuffer.append("合计:" + dataFormat((mobileCard.getConsumAmount()
                + mobileCard.getSerPackage().getPrice())) + "元\n");
        stringBuffer.append("账号余额:" + dataFormat(mobileCard.getMoney()) + "元");
        System.out.println(stringBuffer);
    }

    /**
     * double类型取小数点后一位方法
     *
     * @param data 数据
     * @return dataString
     */
    public static String dataFormat(double data) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        return decimalFormat.format(data);
    }

    /**
     * 添加消费信息
     *
     * @param number 移动卡号
     * @param info   消费信息
     */
    public static void addConsumInfo(String number, ConsumInfo info) {
        if (consumInfos.containsKey(number)) {
            consumInfos.get(number).add(info);
        } else {
            List<ConsumInfo> list = new ArrayList<>();
            list.add(info);
            consumInfos.put(number, list);
        }
    }

    /**
     * 使用嗖嗖
     *
     * @param number 移动卡号
     */
    public static void useSoso(String number) {

        sceneMap.put(0, scene1);
        sceneMap.put(1, scene2);
        sceneMap.put(2, scene3);
        sceneMap.put(3, scene4);
        sceneMap.put(4, scene5);
        sceneMap.put(5, scene6);

        MobileCard card = cards.get(number);
        ServicePackage pack = card.getSerPackage();
        Random random = new Random();
        int ranNum = 0;
        int temp = 0;
        do {
            ranNum = random.nextInt(6);
            Scene scene = sceneMap.get(ranNum);
            switch (ranNum) {
                //通话场景
                case 0:
                case 1:
                    if (pack instanceof CallService) {
                        System.out.println(scene.getDescription());
                        CallService callService = (CallService) pack;
                        try {
                            temp = callService.call(scene.getData(), card);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        addConsumInfo(number, new ConsumInfo(number, scene.getType(), temp));
                        break;
                    } else {
                        continue;
                    }
                    //短信场景
                case 2:
                case 3:
                    if (pack instanceof SendService) {
                        System.out.println(scene.getDescription());
                        SendService sendService = (SendService) pack;
                        try {
                            temp = sendService.send(scene.getData(), card);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        addConsumInfo(number, new ConsumInfo(number, scene.getType(), temp));
                        break;
                    } else {
                        continue;
                    }
                    //流量场景
                case 4:
                case 5:
                    if (pack instanceof NetPackage) {
                        System.out.println(scene.getDescription());
                        NetPackage netPackage = (NetPackage) pack;
                        try {
                            temp = netPackage.netPlay(scene.getData(), card);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        addConsumInfo(number, new ConsumInfo(number, scene.getType(), temp));
                        break;
                    } else {
                        continue;
                    }
            }
            break;
        }
        while (true);
    }

    /**
     * 资费清单打印
     */
    public static void showDescription() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(
                    new FileReader("mobile_service\\src\\资费说明.txt"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 变更套餐
     *
     * @param number  移动卡号
     * @param packNum 套餐编号
     */
    public static void changingPack(String number, int packNum) {
        switch (packNum) {
            case 1:
                if (cards.get(number).getSerPackage() instanceof TalkPackage) {
                    System.out.println("您已经是该套餐用户，无需换套餐。");
                } else {
                    changePackageSettings(number, packNum);
                }
                break;
            case 2:
                if (cards.get(number).getSerPackage() instanceof NetPackage) {
                    System.out.println("您已经是该套餐用户，无需换套餐。");
                } else {
                    changePackageSettings(number, packNum);
                }
                break;
            case 3:
                if (cards.get(number).getSerPackage() instanceof SuperPackage) {
                    System.out.println("您已经是该套餐用户，无需换套餐。");
                } else {
                    changePackageSettings(number, packNum);
                }
                break;
        }
    }

    /**
     * 套餐变更设置
     *
     * @param number  移动卡号
     * @param packNum 套餐编号
     */
    private static void changePackageSettings(String number, int packNum) {
        if (cards.get(number).getMoney() < cards.get(number).getSerPackage().getPrice()) {
            System.out.println("您的余额不足以支付本月套餐资费，请充值后再办理。");
        } else {
            cards.get(number).setRealTalkTime(0);
            cards.get(number).setRealSMSCount(0);
            cards.get(number).setRealFlow(0);
            cards.get(number).setSerPackage(createPackage(packNum));
            //减去月资费
            cards.get(number).setMoney(cards.get(number).getMoney() - cards.get(number).getSerPackage().getPrice());
            System.out.println("套餐变更成功！");
            createPackage(packNum).showInfo();
        }
    }

    /**
     * 套餐消费信息打印
     *
     * @param number 移动卡号
     */
    public static void printConsumInfo(String number) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("mobile_service\\src\\消费清单.txt"));
            Set<String> numbers = consumInfos.keySet();
            Iterator<String> iterator = numbers.iterator();
            List<ConsumInfo> infos = consumInfos.get(number);
            boolean isExist = false;
            while (iterator.hasNext()) {
                String numberKey = iterator.next();
                if (number.equals(numberKey)) {
                    isExist = true;
                }
            }
            if (isExist) {
                StringBuffer stringBuffer = new StringBuffer("********" + number + "消费记录*********\n");
                stringBuffer.append("序号\t类型\t数据（通话（分钟）/上网（MB）/短信（条））\n");
                for (int i = 0; i < infos.size(); i++) {
                    ConsumInfo info = infos.get(i);
                    System.out.println((i + 1) + ".\t" + info.getType() + "\t" + info.getConsumData() + "\n");
                    stringBuffer.append((i + 1) + ".\t" + info.getType() + "\t" + info.getConsumData() + "\n");
                }
                bufferedWriter.write(stringBuffer.toString());
                bufferedWriter.flush();
                System.out.println("消息打印完毕！");

            } else {
                System.out.println("对不起，不存在此号码的消费记录！");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 话费充值
     *
     * @param number 卡号
     * @param money  余额
     */
    public static void chargeMoney(String number, double money) {
        cards.get(number).setMoney(cards.get(number).getMoney() + money);
    }

    public static MobileCard getCard(String number) {
        MobileCard card;
        card = cards.get(number);
        return card;
    }
}

