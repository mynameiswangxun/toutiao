package com.hdutoutiao.vo;

import java.util.Date;

public class MessageVo {

    private Integer id;

    private Integer fromId;

    private Integer toId;

    private String content;

    private Date createTime;

    private Integer conversationId;

    private boolean isSender;

    private String senderName;

    private String senderHeadImg;

    public MessageVo(){}

    public MessageVo(Integer id, Integer fromId, Integer toId, String content, Date createTime, Integer conversationId, boolean isSender, String senderName, String senderHeadImg) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.content = content;
        this.createTime = createTime;
        this.conversationId = conversationId;
        this.isSender = isSender;
        this.senderName = senderName;
        this.senderHeadImg = senderHeadImg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public boolean getIsSender() {
        return isSender;
    }

    public void setIsSender(boolean sender) {
        isSender = sender;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderHeadImg() {
        return senderHeadImg;
    }

    public void setSenderHeadImg(String senderHeadImg) {
        this.senderHeadImg = senderHeadImg;
    }
}
