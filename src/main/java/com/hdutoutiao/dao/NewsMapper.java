package com.hdutoutiao.dao;

import com.hdutoutiao.pojo.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> selectRecentNews();

    int addCommentById(@Param("id") Integer id);

    int addLikeNum(Integer id);

    int reduceLikeNum(Integer id);
}