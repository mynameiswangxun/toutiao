package com.hdutoutiao.vo;

import java.util.Date;

public class CommentVo {

    private Integer id;

    private Integer userId;

    private Integer newsId;

    private String content;

    private Date createTime;

    private String username;

    private String headImage;

    public CommentVo(Integer id, Integer userId, Integer newsId, String content, Date createTime, String username, String headImage) {
        this.id = id;
        this.userId = userId;
        this.newsId = newsId;
        this.content = content;
        this.createTime = createTime;
        this.username = username;
        this.headImage = headImage;
    }
    public CommentVo(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }
}
