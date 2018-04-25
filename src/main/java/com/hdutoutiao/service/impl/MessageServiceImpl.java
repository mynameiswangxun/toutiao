package com.hdutoutiao.service.impl;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.dao.ConversationMapper;
import com.hdutoutiao.dao.MessageMapper;
import com.hdutoutiao.dao.UserMapper;
import com.hdutoutiao.pojo.Conversation;
import com.hdutoutiao.pojo.Message;
import com.hdutoutiao.pojo.User;
import com.hdutoutiao.service.IMessageService;
import com.hdutoutiao.vo.ConversationVo;
import com.hdutoutiao.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("iMessageService")
public class MessageServiceImpl implements IMessageService{

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    ConversationMapper conversationMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String,Object> getMessageVoList(Integer userId,Integer anotherId){
        Map<String,Object> resMap = new HashMap<>();
        List<Message> messages = new ArrayList<>();
        List<MessageVo> messageVoList = new ArrayList<>();
        Conversation conversation = conversationMapper.selectByUserIdAndAnOtherId(userId,anotherId);
        if(conversation!=null){
            messages = messageMapper.selectMessageByConversationId(conversation.getId());
        }
        for (Message message : messages) {
            messageVoList.add(getMessageVo(message,userId));
        }
        resMap.put("code",Const.ResponceCode.SUCCESS);
        resMap.put("messageVoList",messageVoList);
        return resMap;
    }

    @Override
    public Map<String,Object> getConversationVoList(Integer userId){
        Map<String,Object> resMap = new HashMap<>();
        List<Conversation> conversationList = conversationMapper.selectByUserId(userId);
        List<ConversationVo> conversationVoList = new ArrayList<>();
        if(conversationList==null){
            resMap.put("code", Const.ResponceCode.ERROR);
            resMap.put("msg","查找会话失败");
        }
        for(Conversation conversation:conversationList){
            conversationVoList.add(getConversationVo(conversation,userId));
        }
        resMap.put("code", Const.ResponceCode.SUCCESS);
        resMap.put("conversationVoList",conversationVoList);
        return resMap;
    }

    @Override
    public Map<String,Object> createMessage(Integer fromId,Integer toId,String content){
        Map<String,Object> resMap = new HashMap<>();
        Message message = new Message();
        message.setFromId(fromId);
        message.setToId(toId);
        message.setContent(content);
        Conversation conversation = conversationMapper.selectByUserIdAndAnOtherId(fromId,toId);
        if(conversation==null){
            conversation = new Conversation();
            conversation.setFromId(fromId);
            conversation.setToId(toId);
            conversation.setMessageNum(0);
            conversationMapper.insert(conversation);
            conversation = conversationMapper.selectByUserIdAndAnOtherId(fromId,toId);
        }

        message.setConversationId(conversation.getId());

        int count = messageMapper.insert(message);
        if(count==0){
            resMap.put("code", Const.ResponceCode.ERROR);
            resMap.put("msg","新建消息失败");
        }
        count = conversationMapper.addMessage(conversation.getId());
        if(count==0){
            resMap.put("code", Const.ResponceCode.ERROR);
            resMap.put("msg","新建消息失败");
        }
        resMap.put("code",Const.ResponceCode.SUCCESS);
        return resMap;
    }

    private ConversationVo getConversationVo(Conversation conversation,Integer userId){
        ConversationVo conversationVo = new ConversationVo();
        conversationVo.setId(conversation.getId());
        conversationVo.setCreateTime(conversation.getCreateTime());
        conversationVo.setMessageNum(conversation.getMessageNum());
        conversationVo.setUserId(userId);
        Integer otherId = conversation.getFromId()==userId?conversation.getToId():conversation.getFromId();
        conversationVo.setOtherId(otherId);
        User other = userMapper.selectByPrimaryKey(otherId);
        conversationVo.setOtherName(other.getUsername());
        conversationVo.setOtherHeadImg(other.getHeadImage());
        return conversationVo;
    }

    private MessageVo getMessageVo(Message message,Integer userId){
        MessageVo messageVo = new MessageVo();
        messageVo.setId(message.getId());
        messageVo.setFromId(message.getFromId());
        messageVo.setToId(message.getToId());
        messageVo.setContent(message.getContent());
        messageVo.setCreateTime(message.getCreateTime());
        messageVo.setConversationId(message.getConversationId());
        Integer senderId = message.getFromId();
        messageVo.setIsSender(senderId==userId);
        User sender = userMapper.selectByPrimaryKey(senderId);
        messageVo.setSenderHeadImg(sender.getHeadImage());
        return messageVo;
    }
}
