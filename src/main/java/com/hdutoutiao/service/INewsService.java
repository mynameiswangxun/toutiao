package com.hdutoutiao.service;


import java.util.Map;

public interface INewsService {

    Map<String, Object> createNews(Integer userId,String imageUrl,String title,String content);

    Map<String,Object> getRecentNewsVo(Integer userId);

    Map<String,Object> getNewsVoById(Integer newsId,Integer userId);

    Map<String,Object> likeNews(Integer userId,Integer newsId);

    Map<String,Object> dislikeNews(Integer userId,Integer newsId);

}
