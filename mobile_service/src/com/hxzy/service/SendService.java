package com.hxzy.service;

import com.hxzy.entity.MobileCard;

/**
 * 短信服务
 * @author chenyongzhi
 * @create 2019/6/3 16:04
 */
public interface SendService {

    int send(int count, MobileCard card);
}
