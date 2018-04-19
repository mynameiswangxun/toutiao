package com.hdutoutiao.controller;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.pojo.User;
import com.hdutoutiao.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    ICommentService iCommentService;

    @PostMapping("/add")
    public String addComment(HttpSession session, @RequestParam("newsId") Integer newsId,
                             @RequestParam("content") String content){
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "no_login";
        }
        Map<String,Object> resMap = iCommentService.createComment(newsId,user.getId(),content);
        if(resMap.get("code").equals(Const.ResponceCode.ERROR)){
            return "error";
        }
        return "redirect:/news/detail/"+newsId;
    }
}
