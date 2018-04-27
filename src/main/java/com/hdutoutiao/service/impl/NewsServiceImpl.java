package com.hdutoutiao.service.impl;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.dao.NewsMapper;
import com.hdutoutiao.dao.UserMapper;
import com.hdutoutiao.pojo.News;
import com.hdutoutiao.pojo.User;
import com.hdutoutiao.service.INewsService;
import com.hdutoutiao.util.RedisServiceUtil;
import com.hdutoutiao.vo.NewsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("iNewsService")
@Slf4j
public class NewsServiceImpl implements INewsService {

    @Autowired
    NewsMapper newsMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, Object> createNews(Integer userId,String imageUrl,String title,String content) {
        Map<String, Object> resMap = new HashMap<>();
        News news = new News();
        news.setUserId(userId);
        news.setTitle(title);
        news.setContent(content);
        news.setLikeCount(0);
        news.setCommentCount(0);
        news.setMainImage(imageUrl);
        int count = newsMapper.insert(news);
        if(count==0){
            resMap.put("code",Const.ResponceCode.ERROR);
            resMap.put("msg","发布简讯失败");
            return resMap;
        }
        resMap.put("code",Const.ResponceCode.SUCCESS);
        return resMap;
    }

    @Override
    public Map<String,Object> getRecentNewsVo(Integer userId){
        Map<String,Object> resMap = new HashMap<>();
        List<NewsVo> recentNewsVo = new ArrayList<>();
        List<News> recentNews = newsMapper.selectRecentNews();
        for (News news : recentNews) {
            recentNewsVo.add(getNewsVo(news,userId));
        }
        resMap.put("code",Const.ResponceCode.SUCCESS);
        resMap.put("recentNewsVo",recentNewsVo);
        return resMap;
    }
    @Override
    public Map<String,Object> getNewsVoById(Integer newsId,Integer userId){
        Map<String,Object> resMap = new HashMap<>();
        News news = newsMapper.selectByPrimaryKey(newsId);
        if(news==null){
            resMap.put("code",Const.ResponceCode.ERROR);
            resMap.put("msg","该简讯不存在！");
            return resMap;
        }
        NewsVo newsVo = getNewsVo(news,userId);
        resMap.put("code",Const.ResponceCode.SUCCESS);
        resMap.put("newsVo",newsVo);
        return resMap;
    }

    @Override
    public Map<String,Object> likeNews(Integer userId,Integer newsId){
        Map<String,Object> resMap = new HashMap<>();
        if(RedisServiceUtil.isLikeNews(userId,newsId)){
            News news = newsMapper.selectByPrimaryKey(newsId);
            resMap.put("code",Const.ResponceCode.SUCCESS);
            resMap.put("msg",news.getLikeCount());
            return resMap;
        }
        RedisServiceUtil.likeNews(userId,newsId);
        newsMapper.addLikeNum(newsId);
        News news = newsMapper.selectByPrimaryKey(newsId);
        resMap.put("code",Const.ResponceCode.SUCCESS);
        resMap.put("msg",news.getLikeCount());
        return resMap;
    }

    @Override
    public Map<String,Object> dislikeNews(Integer userId,Integer newsId){
        Map<String,Object> resMap = new HashMap<>();
        if(RedisServiceUtil.isDislikeNews(userId,newsId)){
            News news = newsMapper.selectByPrimaryKey(newsId);
            resMap.put("code",Const.ResponceCode.SUCCESS);
            resMap.put("msg",news.getLikeCount());
            return resMap;
        }
        boolean isLike = RedisServiceUtil.isLikeNews(userId,newsId);
        RedisServiceUtil.dislikeNews(userId,newsId);
        if(isLike){
            newsMapper.reduceLikeNum(newsId);
        }
        News news = newsMapper.selectByPrimaryKey(newsId);
        resMap.put("code",Const.ResponceCode.SUCCESS);
        resMap.put("msg",news.getLikeCount());
        return resMap;
    }

    private NewsVo getNewsVo(News news,Integer userId){
        if(news==null){
            return null;
        }
        NewsVo newsVo = new NewsVo();
        newsVo.setId(news.getId());
        newsVo.setCommentCount(news.getCommentCount());
        newsVo.setLikeCount(news.getLikeCount());
        newsVo.setTitle(news.getTitle());
        newsVo.setCreateTime(news.getCreateTime());
        newsVo.setContent(news.getContent());
        newsVo.setMainImage(news.getMainImage());
        User user = userMapper.selectByPrimaryKey(news.getUserId());
        newsVo.setUserId(user.getId());
        newsVo.setUsername(user.getUsername());
        newsVo.setHeadImage(user.getHeadImage());
        if(userId!=null){
            newsVo.setIsLike(RedisServiceUtil.isLikeNews(userId,news.getId()));
            newsVo.setIsDislike(RedisServiceUtil.isDislikeNews(userId,news.getId()));
        }
        return newsVo;
    }
}
