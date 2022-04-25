package org.cwsya.tadmin.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

/**
 * @author cws
 * 序列化工具类(单例)
 */
public class ObjectMapperUtil {

    private static ObjectMapper intstance;

    public static ObjectMapper getIntstance() {
        if (null==intstance){
            synchronized (ObjectMapper.class){
                if (null==intstance){
                    intstance=new ObjectMapper();
                }
            }
        }
        return intstance;
    }

    private ObjectMapperUtil() {
    }

}
