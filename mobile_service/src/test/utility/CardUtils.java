package test.utility;

import com.hx.entity.*;
import com.hx.service.CallService;
import com.hx.service.NetService;
import com.hx.service.SendService;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class CardUtils implements Serializable{
    private static Map<String, MobileCard> cards = new HashMap<String, MobileCard>();
    private static Map<String, List<ConsumInfo>> consumInfos = new HashMap<String, List<ConsumInfo>>();
    static Map<Integer,Scene> sceneMap = new HashMap<Integer, Scene>();

    static File file = new File("E:\\savedata.dat");

    static Scene scene1 = new Scene("通话",100,"拨打电话向好友诉苦，通话100分钟");
    static Scene scene2 = new Scene("通话",20,"跟房东推辞房租，通话20分钟");
    static Scene scene4 = new Scene("短信",10,"向父母索要生活费，发送短信10条");
    static Scene scene3 = new Scene("短信",100,"和女朋友吵架，发送短信100条");
    static Scene scene5 = new Scene("上网",2*1024,"晚上躺被窝里追剧，使用流量2GB");
    static Scene scene6 = new Scene("上网",500,"和室友用热点在电脑上吃鸡，使用流量500MB");



    /*
    * 保存
    * */
    public static void saveData() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(cards);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * 读取
     * */
    public static void loadData() {
        if(file.length()!=0){
            try {
                ObjectInput oi = new ObjectInputStream(new FileInputStream(file));
                cards = (Map<String, MobileCard>)oi.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    * 用户初始化
    * */
    //使用情景初始
    public static void initScene() {
        MobileCard mc1 = new MobileCard("13912312312","gz","123",0,200,0,0,0,new TalkPackage());
        MobileCard mc2 = new MobileCard("13932132132","mf","123",0,160,0,0,0,new NetPackage());
        MobileCard mc3 = new MobileCard("13911111111","zgw","123",0,300,0,0,0,new SuperPackage());

        cards.put("13912312312",mc1);
        cards.put("13932132132",mc2);
        cards.put("13911111111",mc3);

        ConsumInfo info = new ConsumInfo("12345678910","电话",0);

        List<ConsumInfo> list = new ArrayList<ConsumInfo>();
        list.add(info);
        consumInfos.put(info.getCardNumber(),list);

    }

    //登陆验证
    public static boolean isExistCard(String number, String passWord) {
        if(cards.containsKey(number)&&(cards.get(number).getPassWord().equals(passWord))){
            return true;
        }
        else {
            System.out.println("登录失败!");
            return false;
        }
    }

    //话费充值认证
    public static boolean isExistCard(String number) {
        Set<String> numbers = cards.keySet();
        Iterator<String> iterator = numbers.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if(str.equals(number)){
                return true;
            }
        }
        return false;
    }

    //返回套餐对象
    public static ServicePackage createPackage(int packID) {
        ServicePackage servicePackage=null;
        switch (packID){
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


    //生成随机卡号
    public static String createNumber(){
        //boolean isExist = false;
        Random random = new Random();
        int temp = (int)((Math.random()*9+1)*10000000);
        String number = "139"+temp;
        /*if(cards!=null){
            Set<String> cardNumbers = cards.keySet();
            for(String cards:cardNumbers){
                if(number.equals(cardNumbers)){
                    //isExist = true;
                    break;
                }
            }
        }*/
        return number;
    }

    //生成指定个数卡号的表
    public static String[] getNewNumbers(int count){
        String[] strings = new String[count];
        for (int i=0; i<count;) {
            if(isExistCard(createNumber())){
                continue;
            }
            else{
                strings[i]=createNumber();
                i++;
            }
        }
        return  strings;
    }

    //注册新卡
    public static void addCard(MobileCard card){
        cards.put(card.getCardNumber(),card);
    }

    //删除手机卡，退网
    public static void delCard(String number){
        if(cards.containsKey(number)) {
            cards.remove(number);
            System.out.println("卡号"+number+"办理退网成功！");
            System.out.println("谢谢使用！");
        }
        else{
            System.out.println("手机号码输入有误！");
        }

    }
    /*
    *
    * */
    //套餐余量查询
    public static void showRemainDetail(String number){
        MobileCard card = cards.get(number);
        int remainTalkTime;
        int remainSmsCount;
        int remainFlow;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("您的卡号是"+number+",套餐内剩余：\n");
        ServicePackage servicePackage = card.getSerPackage();
        if(servicePackage instanceof NetPackage){
            //向下转型
            NetPackage netPackage = (NetPackage) servicePackage;
            remainFlow=netPackage.getFlow()>card.getRealFlow()?netPackage.getFlow()-card.getRealFlow():0;
            stringBuffer.append("上网流量："+(remainFlow/1024)+"GB");
        }
        else if (servicePackage instanceof TalkPackage){
            //向下转型
            TalkPackage talkPackage = (TalkPackage) servicePackage;
            remainTalkTime = talkPackage.getTalkTime()>card.getRealTalkTime()?talkPackage.getTalkTime()-card.getRealTalkTime():0;
            stringBuffer.append("通话时长："+remainTalkTime+"分钟\n");

            remainSmsCount = talkPackage.getSmsCount()>card.getRealSMSCount()?talkPackage.getSmsCount()-card.getRealSMSCount():0;
            stringBuffer.append("短信条数："+remainSmsCount+"条");

        }
        else {
            //向下转型
            SuperPackage superPackage = (SuperPackage) servicePackage;

            remainTalkTime=superPackage.getTalkTime()>card.getRealTalkTime()?superPackage.getTalkTime()-card.getRealTalkTime():0;
            stringBuffer.append("通话时长："+remainTalkTime+"分钟\n");

            remainSmsCount=superPackage.getSmsCount()>card.getRealSMSCount()?superPackage.getSmsCount()-card.getRealSMSCount():0;
            stringBuffer.append("短信条数："+remainSmsCount+"条\n");

            remainFlow=superPackage.getFlow()>card.getRealFlow()?superPackage.getFlow()-card.getRealFlow():0;
            stringBuffer.append("上网流量："+remainFlow/1024+"GB");
        }
        System.out.println(stringBuffer);
    }
    /*
    *
    *
    * */
    //套餐本月账单查询
    public static void showAmountDetail(String number){
        StringBuffer stringBuffer = new StringBuffer();
        MobileCard mobileCard = cards.get(number);
        stringBuffer.append("***********************************\n");
        stringBuffer.append("您的卡号："+mobileCard.getCardNumber()+"\n当月账单:\n");
        stringBuffer.append("您的套餐："+mobileCard.getSerPackage().getName()+"\n");
        stringBuffer.append("套餐资费："+mobileCard.getSerPackage().getPrice()+"元\n");
        stringBuffer.append("合计:"+ dataFormat((mobileCard.getConsumAmount() + mobileCard.getSerPackage().getPrice()))+"元\n");
        stringBuffer.append("账号余额:"+dataFormat(mobileCard.getMoney())+"元");
        System.out.println(stringBuffer);
    }

    /*
    *double类型取小数点后一位方法
    * */
    public static String dataFormat(double data) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        return  decimalFormat.format(data);
    }

    /*
    * 存消费信息
    * */
    //
    public static void addConsumInfo(String number,ConsumInfo info){
        if (consumInfos.containsKey(number)) {
            consumInfos.get(number).add(info);
        }
        else{
            List<ConsumInfo> list = new ArrayList<ConsumInfo>();
            list.add(info);
            consumInfos.put(number,list);
        }
    }

    /*
    * 使用嗖嗖
    * */
    //
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

    /*
     * 测试使用嗖嗖
     * */
    /*public static void useSoso(String number){
        sceneMap.put(0, scene1);
        sceneMap.put(1, scene2);
        sceneMap.put(2, scene3);
        sceneMap.put(3, scene4);
        sceneMap.put(4, scene5);
        sceneMap.put(5, scene6);

        MobileCard card = cards.get(number);
        ServicePackage pack = card.getSerPackage();
        int temp = 0;
        //1
        Scene scene = sceneMap.get(2);
        System.out.println(scene.getDescription());
        SendService sendService = (SendService) pack;
        temp = sendService.send(scene.getData(), card);
        addConsumInfo(number, new ConsumInfo(number, scene.getType(), temp));


        Scene scene = sceneMap.get(0);
        System.out.println(scene.getDescription());
        CallService callService = (CallService) pack;
        temp = callService.call(scene.getData(), card);
        addConsumInfo(number, new ConsumInfo(number, scene.getType(), temp));*//*


        Scene scene = sceneMap.get(4);
        System.out.println(scene.getDescription());
        NetService netService = (NetService) pack;
        temp = netService.netPlay(scene.getData(), card);
        addConsumInfo(number, new ConsumInfo(number, scene.getType(), temp));*//*
    }*/


    //
    /*
    * 资费说明
    * */
    public static void showDescription(){
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("E:/资费说明.txt"));
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*
    * 套餐变更
    * */
    //换套餐
    public static void changingPack (String number, int packNum){
        switch (packNum){
            case 1:
                if(cards.get(number).getSerPackage() instanceof TalkPackage) {
                    System.out.println("您已经是该套餐用户，无需换套餐。");
                }
                else {
                    if(cards.get(number).getMoney()<cards.get(number).getSerPackage().getPrice()){
                        System.out.println("您的余额不足以支付本月套餐资费，请充值后再办理。");
                    }
                    else{
                        cards.get(number).setRealTalkTime(0);
                        cards.get(number).setRealSMSCount(0);
                        cards.get(number).setRealFlow(0);
                        cards.get(number).setSerPackage(createPackage(packNum));
                        //减去月资费
                        cards.get(number).setMoney(cards.get(number).getMoney()-cards.get(number).getSerPackage().getPrice());
                        System.out.println("套餐变更成功！");
                        createPackage(packNum).showInfo();
                    }
                }
                break;
            case 2:
                if(cards.get(number).getSerPackage() instanceof NetPackage) {
                    System.out.println("您已经是该套餐用户，无需换套餐。");
                }
                else {
                    if(cards.get(number).getMoney()<cards.get(number).getSerPackage().getPrice()){
                        System.out.println("您的余额不足以支付本月套餐资费，请充值后再办理。");
                    }
                    else{
                        cards.get(number).setRealTalkTime(0);
                        cards.get(number).setRealSMSCount(0);
                        cards.get(number).setRealFlow(0);
                        cards.get(number).setSerPackage(createPackage(packNum));
                        //减去月资费
                        cards.get(number).setMoney(cards.get(number).getMoney()-cards.get(number).getSerPackage().getPrice());
                        System.out.println("套餐变更成功！");
                        createPackage(packNum).showInfo();
                    }
                }
                break;
            case 3:
                if(cards.get(number).getSerPackage() instanceof SuperPackage) {
                    System.out.println("您已经是该套餐用户，无需换套餐。");
                }
                else {
                    if(cards.get(number).getMoney()<cards.get(number).getSerPackage().getPrice()){
                        System.out.println("您的余额不足以支付本月套餐资费，请充值后再办理。");
                    }
                    else{
                        cards.get(number).setRealTalkTime(0);
                        cards.get(number).setRealSMSCount(0);
                        cards.get(number).setRealFlow(0);
                        cards.get(number).setSerPackage(createPackage(packNum));
                        //减去月资费
                        cards.get(number).setMoney(cards.get(number).getMoney()-cards.get(number).getSerPackage().getPrice());
                        System.out.println("套餐变更成功！");
                        createPackage(packNum).showInfo();
                    }
                }
                break;
        }
    }
    /*
    *
    *
    * */
    //打印消费详单
    public static void printConsumInfo(String number){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\Test.txt"));
            Set<String> numbers = consumInfos.keySet();
            Iterator<String> iterator = numbers.iterator();
            List<ConsumInfo> infos = new ArrayList<ConsumInfo>();
            infos = consumInfos.get(number);
            boolean isExist = false;
            while (iterator.hasNext()){
                String numberKey = iterator.next();
                if(number.equals(numberKey)){
                    isExist= true;
                }
            }
            if(isExist) {
                StringBuffer stringBuffer = new StringBuffer("********"+number+"消费记录*********\n");
                stringBuffer.append("序号\t类型\t数据（通话（分钟）/上网（MB）/短信（条））\n");
                for(int i =0; i<infos.size();i++){
                    ConsumInfo info = infos.get(i);
                    System.out.println((i+1)+".\t"+info.getType()+"\t"+info.getConsumData()+"\n");
                    stringBuffer.append((i+1)+".\t"+info.getType()+"\t"+info.getConsumData()+"\n");
                }
                bufferedWriter.write(stringBuffer.toString());
                bufferedWriter.flush();
                System.out.println("消息打印完毕！");

            }
            else{
                System.out.println("对不起，不存在此号码的消费记录！");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*
    * 话费充值
    * */
    //
    public static void chargeMoney(String number, double money) {
        cards.get(number).setMoney(cards.get(number).getMoney()+money);
    }


    public static MobileCard getCard(String number){
        MobileCard card;
        card= cards.get(number);
        return card;
    }





}
