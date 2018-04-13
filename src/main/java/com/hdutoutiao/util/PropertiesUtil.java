package com.hdutoutiao.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

@Slf4j
public class PropertiesUtil {

    private static Properties properties;

    static {
        String fileName = "toutiao.properties";
        properties = new Properties();
        try{
            properties.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName)));
        }catch (IOException e){
            log.error("配置文件读取异常",e);
        }
    }

    public static String getProperty(String key){
        String value = properties.getProperty(key.trim());
        if(StringUtils.isEmpty(value)){
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key,String defaultValue){
        String value = properties.getProperty(key.trim());
        if(StringUtils.isEmpty(value)){
            return defaultValue;
        }
        return value.trim();
    }
}