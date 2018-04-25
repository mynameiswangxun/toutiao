package com.hdutoutiao.vo;

import java.util.Date;

public class ConversationVo {
    private Integer id;

    private Integer messageNum;

    private Integer userId;

    private Integer otherId;

    private String otherHeadImg;

    private String otherName;

    private Date createTime;

    public ConversationVo(){}

    public ConversationVo(Integer id, Integer messageNum, Integer userId, Integer otherId, String otherHeadImg, String otherName, Date createTime) {
        this.id = id;
        this.messageNum = messageNum;
        this.userId = userId;
        this.otherId = otherId;
        this.otherHeadImg = otherHeadImg;
        this.otherName = otherName;
        this.createTime = createTime;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOtherId() {
        return otherId;
    }

    public void setOtherId(Integer otherId) {
        this.otherId = otherId;
    }

    public String getOtherHeadImg() {
        return otherHeadImg;
    }

    public void setOtherHeadImg(String otherHeadImg) {
        this.otherHeadImg = otherHeadImg;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
