package com.hdutoutiao.service;


import java.util.Map;

public interface INewsService {

    Map<String, Object> createNews(Integer userId,String imageUrl,String title,String content);

    Map<String,Object> getRecentNewsVo();

    Map<String,Object> getNewsVoById(Integer id);
}
