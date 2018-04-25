package com.hdutoutiao.service;

import java.util.Map;

public interface IMessageService {

    Map<String,Object> createMessage(Integer fromId, Integer toId, String content);

    Map<String,Object> getConversationVoList(Integer userId);

    Map<String,Object> getMessageVoList(Integer userId,Integer anotherId);
}
