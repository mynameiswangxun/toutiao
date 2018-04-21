package com.hdutoutiao.pojo;

import java.util.Date;

public class Message {
    private Integer id;

    private Integer fromId;

    private Integer toId;

    private String content;

    private Integer conversationId;

    private Date createTime;

    public Message(Integer id, Integer fromId, Integer toId, String content, Integer conversationId, Date createTime) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.content = content;
        this.conversationId = conversationId;
        this.createTime = createTime;
    }

    public Message() {
        super();
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
        this.content = content == null ? null : content.trim();
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}