package com.hdutoutiao.controller;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.pojo.Comment;
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
        Map<String,Object> resMap = iNewsService.getNewsVoById(id);
        if(resMap.get("code").equals(Const.ResponceCode.ERROR)){
            return "page_not_found";
        }else{
            model.addAttribute("newsVo",resMap.get("newsVo"));
            Map<String,Object> OtherResMap  = iCommentService.getRecentCommentVo(((NewsVo)resMap.get("newsVo")).getId());
            model.addAttribute("recentCommentVo",OtherResMap.get("recentCommentVo"));
        }
        return "news_detail";
    }
}
