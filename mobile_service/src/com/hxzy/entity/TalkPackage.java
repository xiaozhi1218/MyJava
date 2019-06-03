package com.hxzy.entity;

import com.hxzy.service.CallService;
import com.hxzy.service.SendService;

/**
 * @author chenyongzhi
 * @create 2019/6/3 15:31
 */
public class TalkPackage extends ServicePackage implements CallService, SendService {

    public int talkTime;
    public int smsCount;

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
}
