package com.hdutoutiao.controller;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.pojo.User;
import com.hdutoutiao.service.ICommentService;
import com.hdutoutiao.service.INewsService;
import com.hdutoutiao.util.JsonUtil;
import com.hdutoutiao.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    INewsService iNewsService;

    @Autowired
    ICommentService iCommentService;

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

    @GetMapping("/detail/{id}")
    public String newsDetail(HttpSession session, Model model, @PathVariable("id") Integer id){
        User user = (User)session.getAttribute("user");
        if(user!=null){
            model.addAttribute("user",user);
        }
        Map<String,Object> resMap = iNewsService.getNewsVoById(id,user==null?null:user.getId());
        if(resMap.get("code").equals(Const.ResponceCode.ERROR)){
            return "page_not_found";
        }else{
            model.addAttribute("newsVo",resMap.get("newsVo"));
            Map<String,Object> OtherResMap  = iCommentService.getRecentCommentVo(((NewsVo)resMap.get("newsVo")).getId());
            model.addAttribute("recentCommentVo",OtherResMap.get("recentCommentVo"));
        }
        return "news_detail";
    }

    //msg返回like数目既可
    @PostMapping("/like")
    @ResponseBody
    public String likeNews(HttpSession session,@RequestParam("newsId") Integer newsId){
        User user = (User)session.getAttribute("user");
        if(user==null){
            return JsonUtil.getJsonString(Const.ResponceCode.ERROR,"用户未登录");
        }
        Map<String,Object> resMap = iNewsService.likeNews(user.getId(),newsId);
        return JsonUtil.getJsonString(resMap);
    }
    //同上
    @PostMapping("/dislike")
    @ResponseBody
    public String dislikeNews(HttpSession session,@RequestParam("newsId") Integer newsId){
        User user = (User)session.getAttribute("user");
        if(user==null){
            return JsonUtil.getJsonString(Const.ResponceCode.ERROR,"用户未登录");
        }
        Map<String,Object> resMap = iNewsService.dislikeNews(user.getId(),newsId);
        return JsonUtil.getJsonString(resMap);
    }

}
