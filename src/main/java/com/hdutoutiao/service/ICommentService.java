package com.hdutoutiao.service;

import java.util.Map;

public interface ICommentService {

    Map<String,Object> createComment(Integer newsId, Integer userId, String content);

    Map<String,Object> getRecentCommentVo(Integer newsId);
}
