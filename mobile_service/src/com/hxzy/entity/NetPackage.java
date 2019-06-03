package com.hxzy.entity;

import com.hxzy.service.NetService;

/**
 * @author chenyongzhi
 * @create 2019/6/3 15:46
 */
public class NetPackage extends ServicePackage implements NetService {

    public int flow;

    @Override
    public void showInfo() {

    }

    @Override
    public int netPlay(int flow, MobileCard card) {
        return 0;
    }
}
