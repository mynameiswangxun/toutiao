package com.hdutoutiao.controller;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.pojo.User;
import com.hdutoutiao.service.INewsService;
import com.hdutoutiao.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    INewsService iNewsService;

    @PostMapping("/create")
    @ResponseBody
    public String createNews(HttpSession session,@RequestParam("imageUrl") String imageUrl,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content){
        User user = (User)session.getAttribute("user");
        if(user==null){
            return JsonUtil.getJsonString(Const.ResponceCode.ERROR,"用户未登录");
        }
        Map<String,Object> resMap = iNewsService.createNews(user.getId(),imageUrl,title,content);
        return JsonUtil.getJsonString(resMap);
    }
}
