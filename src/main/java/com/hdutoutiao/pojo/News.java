package com.hdutoutiao.pojo;

import java.util.Date;

public class News {
    private Integer id;

    private Integer userId;

    private String title;

    private String mainImage;

    private Integer likeCount;

    private Integer commentCount;

    private String content;

    private Date createTime;

    public News(Integer id, Integer userId, String title, String mainImage, Integer likeCount, Integer commentCount, String content, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.mainImage = mainImage;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.content = content;
        this.createTime = createTime;
    }

    public News() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
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