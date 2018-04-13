package com.hdutoutiao.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String headImage;

    private Date createTime;

    public User(Integer id, String username, String password, String headImage, Date createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.headImage = headImage;
        this.createTime = createTime;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage == null ? null : headImage.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}