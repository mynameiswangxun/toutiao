package com.hdutoutiao.service.impl;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.dao.CommentMapper;
import com.hdutoutiao.dao.UserMapper;
import com.hdutoutiao.pojo.Comment;
import com.hdutoutiao.pojo.User;
import com.hdutoutiao.service.ICommentService;
import com.hdutoutiao.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("iCommentService")
public class CommentSerivceImpl implements ICommentService{

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String,Object> createComment(Integer newsId,Integer userId,String content)
    {
        Map<String, Object> resMap = new HashMap<>();
        Comment comment = new Comment();
        comment.setNewsId(newsId);
        comment.setUserId(userId);
        comment.setContent(content);
        int count = commentMapper.insert(comment);
        if(count<1){
            resMap.put("code", Const.ResponceCode.ERROR);
            resMap.put("msg","添加评论失败");
        }
        resMap.put("code",Const.ResponceCode.SUCCESS);
        return resMap;
    }

    @Override
    public Map<String,Object> getRecentCommentVo(Integer newsId){
        Map<String,Object> resMap = new HashMap<>();
        List<Comment> recentComment = commentMapper.selectRecentCommentByNewsId(newsId);
        List<CommentVo> recentCommentVo = new ArrayList<>();
        for (Comment comment : recentComment) {
            recentCommentVo.add(getCommentVo(comment));
        }
        resMap.put("code",Const.ResponceCode.SUCCESS);
        resMap.put("recentCommentVo",recentCommentVo);
        return resMap;
    }

    private CommentVo getCommentVo(Comment comment){
        CommentVo commentVo = new CommentVo();
        commentVo.setId(comment.getId());
        commentVo.setContent(comment.getContent());
        commentVo.setNewsId(comment.getNewsId());
        commentVo.setCreateTime(comment.getCreateTime());
        commentVo.setUserId(comment.getUserId());
        User user = userMapper.selectByPrimaryKey(comment.getUserId());
        commentVo.setUsername(user.getUsername());
        commentVo.setHeadImage(user.getHeadImage());
        return commentVo;
    }
}
