package com.karat.cn.util;

import java.util.UUID;

/**
 * 生成主键
 */
public class IdUtil {

    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String uuidStr=uuid.toString();
        return uuidStr;
    }
}
