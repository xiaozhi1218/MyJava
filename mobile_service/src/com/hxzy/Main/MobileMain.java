package com.hxzy.Main;

import com.hxzy.entity.MobileCard;
import com.hxzy.entity.ServicePackage;
import com.hxzy.util.CardUtil;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author chenyongzhi
 * @create 2019/6/3 16:30
 */
public class MobileMain implements Serializable {

    public Scanner scanner = new Scanner(System.in);

    public String packNum = "";

    public ServicePackage servicePackage = null;


    public static void main(String[] args) {

        CardUtil.loadData();
        CardUtil.initScene();
        CardUtil.saveData();
        MobileMain mobileMain = new MobileMain();
        mobileMain.mainMenu();
    }

    /**
     * 主菜单
     */
    public void mainMenu() {

        do {
            System.out.println("*******************欢迎使用嗖嗖移动业务大厅*******************");
            System.out.println("1.用户登录 2.用户注册 3.使用嗖嗖 4.话费充值 5.资费说明 6.退出系统");
            System.out.println("请选择：");

            int input = 0;
            while (true) {
                try {
                    input = scanner.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println("请输入数字1-6!");
                    scanner.nextLine();
                    //input = scanner.nextInt();
                }
                if (1 <= input && 6 >= input) {
                    break;
                }
            }
            switch (input) {
                case 1:
                    login();
                    continue;
                case 2:
                    registerCard();
                    continue;
                case 3:
                    useSosoMenu();
                    continue;
                case 4:
                    moneyRecharge();
                    continue;
                case 5:
                    CardUtil.showDescription();
                    continue;
                case 6:
                    System.out.println("谢谢使用！");
                    System.exit(0);

            }

        }
        while (true);
    }

    private void useSosoMenu() {
        System.out.println("****************************");
        System.out.println("执行使用嗖嗖功能");
        System.out.println("请输入手机卡号：");
        try {
            String number = scanner.next();
            CardUtil.useSoso(number);
        } catch (Exception e) {
            System.out.println("您的号码输入错误！");
        }
    }

    /**
     * 注册二级菜单
     */
    private void registerCard() {

        MobileCard mobileCard = new MobileCard();
        System.out.println("*******可选择的卡号*******");
        //
        String[] cardNumber = CardUtil.getNewNumbers(9);
        for (int i = 0; i < cardNumber.length; i++) {
            System.out.print((i + 1) + "." + cardNumber[i] + "\t");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
        System.out.println("请选择卡号（输入序号1-9）：");
        int input = 0;
        while (true) {
            try {
                input = scanner.nextInt();
                if (input >= 1 && input <= 9) {
                    //存卡号
                    mobileCard.setCardNumber(cardNumber[input - 1]);
                    System.out.println("1.话唠套餐 2.网虫套餐 3.超人套餐，请选择套餐：");
                    break;
                } else {
                    System.out.println("请重新输入（数字1-9）：");
                }
            } catch (InputMismatchException e) {
                System.out.println("请重新输入（数字1-9）：");
                scanner.nextLine();
            }
        }

        int packageNum = 0;
        while (true) {
            try {
                packageNum = scanner.nextInt();
                if (packageNum <= 3 && packageNum >= 1) {
                    servicePackage = CardUtil.createPackage(packageNum);//创建套餐
                    mobileCard.setSerPackage(servicePackage);//给卡设置套餐类型
                    break;
                } else {
                    System.out.println("请重新输入（数字1-3）：");
                    //packageNum = scanner.nextInt();
                }
            } catch (Exception e) {
                System.out.println("请重新输入（数字1-3）：");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        System.out.println("请输入姓名：");
        String userName = scanner.nextLine();
        System.out.println("请输入密码：");
        String passWord = scanner.nextLine();
        System.out.println("请输入预存话费：");

        double money = 0;
        while (true) {
            try {
                money = scanner.nextDouble();
                if (money < servicePackage.getPrice()) {
                    System.out.println("您的预存话费不足以支付您要用的套餐，请重新存钱：");
                    //money = scanner.nextDouble();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("请重新输入话费金额：");
                scanner.nextLine();
            }
        }
        mobileCard.setMoney(money - servicePackage.getPrice());//设置卡的余额，等于充值金额减去套餐费用
        //将卡的信息存入一张新卡里面
        MobileCard card = new MobileCard(mobileCard.getCardNumber(), userName, passWord, mobileCard.getMoney(), mobileCard.getSerPackage());
        CardUtil.addCard(card);
        CardUtil.saveData();
        System.out.println("注册完成！");
        card.showMeg();//打印卡的信息
    }

    /**
     * 登录二级菜单
     */
    public void login() {
        System.out.println("请输入手机卡号：");
        scanner.nextLine();
        String cardNumber = scanner.nextLine();
        System.out.println("请输入密码：");
        String passWord = scanner.nextLine();
        if (CardUtil.isExistCard(cardNumber, passWord)) {
            System.out.println("登陆成功！");
        } else {
            return;
        }
        do {
            System.out.println("*******************嗖嗖移动用户菜单*******************");
            System.out.println("1.本月账单查询\n2.套餐余量查询\n3.打印消费详单\n4.套餐变更\n5.办理退网");
            System.out.println("请选择，输入6返回上一级");

            int input = 0;
            while (true) {
                try {
                    input = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("请输入数字1-6！");
                    scanner.nextLine();
                }
                if (1 <= input && 6 >= input) {
                    break;
                }
            }
            switch (input) {
                case 1:
                    CardUtil.showAmountDetail(cardNumber);
                    continue;
                case 2:
                    CardUtil.showRemainDetail(cardNumber);
                    continue;
                case 3:
                    CardUtil.printConsumInfo(cardNumber);
                    continue;
                case 4:
                    changingPackMenu(cardNumber);
                    CardUtil.saveData();
                    continue;
                case 5:
                    CardUtil.delCard(cardNumber);
                    CardUtil.saveData();
                    new MobileMain().mainMenu();
                    continue;
                case 6:
                    new MobileMain().mainMenu();
                    break;
            }
        } while (true);
    }

    /**
     * 话费充值菜单
     */
    public void moneyRecharge() {

        System.out.println("请输入手机卡号：");
        String number = scanner.next();
        if (CardUtil.isExistCard(number)) {
            System.out.println("请输入充值额：");
            double money = scanner.nextInt();
            CardUtil.chargeMoney(number, money);
            System.out.println("充值成功，当前话费余额为：" + CardUtil.getCard(number).getMoney() + "元");
        } else {
            System.out.println("手机输入有误，请重新输入手机号！");

        }
    }

    /**
     * 套餐变更餐单
     *
     * @param cardNum
     */
    public void changingPackMenu(String cardNum) {
        System.out.println("*********************套餐变更*********************");
        System.out.println("请选择您想改变的套餐：\n1.话唠套餐 2.网虫套餐 3.超人套餐 \n请选择：");
        int packNum = scanner.nextInt();
        CardUtil.changingPack(cardNum, packNum);
    }
}
