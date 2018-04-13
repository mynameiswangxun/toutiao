package com.hdutoutiao.pojo;

import java.util.Date;

public class Comment {
    private Integer id;

    private Integer userId;

    private Integer newsId;

    private String content;

    private Date createTime;

    public Comment(Integer id, Integer userId, Integer newsId, String content, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.newsId = newsId;
        this.content = content;
        this.createTime = createTime;
    }

    public Comment() {
        super();
    }

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
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}