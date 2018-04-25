package com.hdutoutiao.dao;

import com.hdutoutiao.pojo.Conversation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConversationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Conversation record);

    int insertSelective(Conversation record);

    Conversation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Conversation record);

    int updateByPrimaryKey(Conversation record);

    List<Conversation> selectByUserId(Integer userId);

    Conversation selectByUserIdAndAnOtherId(@Param("userId") Integer userId, @Param("anotherId")Integer anotherId);

    int addMessage(Integer id);
}