package com.boot.common.utils;

import java.util.UUID;

/**
 * 媒体地址联调地址 key 生成工具类
 * Created by huquanbo on 2018/11/15.
 */
public class MediaLocationUtils {

    /**
     * 32位唯一字符串
     * @return
     */
    public static String generateKey(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
