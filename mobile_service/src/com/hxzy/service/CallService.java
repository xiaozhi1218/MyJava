package com.hxzy.service;

import com.hxzy.entity.MobileCard;

/**
 * @author chenyongzhi
 * @create 2019/6/3 16:02
 */
public interface CallService {

    int call(int minCount, MobileCard card);
}
