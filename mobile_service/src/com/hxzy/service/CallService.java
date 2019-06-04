package com.hxzy.service;

import com.hxzy.entity.MobileCard;

/**
 * 通话服务
 * @author chenyongzhi
 * @create 2019/6/3 16:02
 */
public interface CallService {

    int call(int minCount, MobileCard card);
}
