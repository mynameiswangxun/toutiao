package com.hdutoutiao.pojo;

import java.util.Date;

public class Message {
    private Integer id;

    private Integer fromid;

    private Integer toid;

    private String content;

    private Integer conversationId;

    private Date createTime;

    public Message(Integer id, Integer fromid, Integer toid, String content, Integer conversationId, Date createTime) {
        this.id = id;
        this.fromid = fromid;
        this.toid = toid;
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

    public Integer getFromid() {
        return fromid;
    }

    public void setFromid(Integer fromid) {
        this.fromid = fromid;
    }

    public Integer getToid() {
        return toid;
    }

    public void setToid(Integer toid) {
        this.toid = toid;
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