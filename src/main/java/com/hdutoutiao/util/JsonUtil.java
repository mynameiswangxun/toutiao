package com.hdutoutiao.util;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class JsonUtil {

    public static String getJsonString(int code){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        return jsonObject.toJSONString();
    }

    public static String getJsonString(int code, Map<String,Object> map){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        for (Map.Entry<String,Object> entry: map.entrySet()) {
            jsonObject.put(entry.getKey(),entry.getValue());
        }
        return jsonObject.toJSONString();
    }

    public static String getJsonString(int code, String msg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        return jsonObject.toJSONString();
    }

    public static String getJsonString(int code, String key ,Object value){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put(key,value);
        return jsonObject.toJSONString();
    }

    public static String getJsonString(Map<String,Object> map){
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String,Object> entry: map.entrySet()) {
            jsonObject.put(entry.getKey(),entry.getValue());
        }
        return jsonObject.toJSONString();
    }

}
