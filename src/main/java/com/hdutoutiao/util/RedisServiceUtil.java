package com.hdutoutiao.util;

public class RedisServiceUtil {

    public static final String 	SEPARATOR = ":";

    public static boolean isLikeNews(Integer userId,Integer newsId){
        String key = "NEWS"+SEPARATOR+"LIKE"+SEPARATOR+newsId;
        return RedisPoolUtil.sismember(key,userId.toString());
    }
    public static boolean likeNews(Integer userId,Integer newsId){
        String key = "NEWS"+SEPARATOR+"LIKE"+SEPARATOR+newsId;
        long count = RedisPoolUtil.sadd(key,userId.toString());
        RedisPoolUtil.srem("NEWS"+SEPARATOR+"DISLIKE"+SEPARATOR+newsId,userId.toString());
        if(count>0){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isDislikeNews(Integer userId,Integer newsId){
        String key = "NEWS"+SEPARATOR+"DISLIKE"+SEPARATOR+newsId;
        return RedisPoolUtil.sismember(key,userId.toString());
    }
    public static boolean dislikeNews(Integer userId,Integer newsId){
        String key = "NEWS"+SEPARATOR+"DISLIKE"+SEPARATOR+newsId;
        long count = RedisPoolUtil.sadd(key,userId.toString());
        RedisPoolUtil.srem("NEWS"+SEPARATOR+"LIKE"+SEPARATOR+newsId,userId.toString());
        if(count>0){
            return true;
        }else {
            return false;
        }
    }
}
