package com.hdutoutiao.pojo;

import java.util.Date;

public class Conversation {
    private Integer id;

    private Integer messageNum;

    private Integer fromId;

    private Integer toId;

    private Date createTime;

    public Conversation(Integer id, Integer messageNum, Integer fromId, Integer toId, Date createTime) {
        this.id = id;
        this.messageNum = messageNum;
        this.fromId = fromId;
        this.toId = toId;
        this.createTime = createTime;
    }

    public Conversation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(Integer messageNum) {
        this.messageNum = messageNum;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}