package com.hxzy.entity;

import com.hxzy.service.CallService;
import com.hxzy.service.NetService;
import com.hxzy.service.SendService;

/**
 * @author chenyongzhi
 * @create 2019/6/3 15:54
 */
public class SuperPackage extends ServicePackage implements CallService, SendService, NetService {

    public int talkTime;
    public int smsCount;
    public int flow;

    @Override
    public void showInfo() {

    }

    @Override
    public int call(int minCount, MobileCard card) {
        return 0;
    }

    @Override
    public int send(int count, MobileCard card) {
        return 0;
    }

    @Override
    public int netPlay(int flow, MobileCard card) {
        return 0;
    }
}
