package com.hdutoutiao.vo;

import java.util.Date;

public class NewsVo {

    private Integer id;

    private Integer userId;

    private String title;

    private String mainImage;

    private Integer likeCount;

    private Integer commentCount;

    private String content;

    private String username;

    private String headImage;

    private Date createTime;

    public NewsVo(Integer id, Integer userId, String title, String mainImage, Integer likeCount, Integer commentCount, String content, String username, String headImage, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.mainImage = mainImage;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.content = content;
        this.username = username;
        this.headImage = headImage;
        this.createTime = createTime;
    }

    public NewsVo(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
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
        this.content = content;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
