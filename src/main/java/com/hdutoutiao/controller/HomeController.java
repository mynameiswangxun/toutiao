package com.hdutoutiao.controller;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.dao.CommentMapper;
import com.hdutoutiao.dao.NewsMapper;
import com.hdutoutiao.pojo.Comment;
import com.hdutoutiao.pojo.User;
import com.hdutoutiao.service.INewsService;
import com.hdutoutiao.service.IUserService;
import com.hdutoutiao.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

//freemarker使用https://blog.csdn.net/gebitan505/article/details/55101678
// && https://blog.csdn.net/qq_37355731/article/details/77049804
@Controller
public class HomeController {

    @Autowired
    IUserService iUserService;

    @Autowired
    INewsService iNewsService;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user!=null){
            model.addAttribute("user",user);
        }
        Map<String,Object> resMap = iNewsService.getRecentNewsVo(user==null?null:user.getId());
        if(resMap.get("code").equals(Const.ResponceCode.SUCCESS)){
            model.addAttribute("recentNewsVo",(List<NewsVo>)resMap.get("recentNewsVo"));
        }
        return "home";
    }

    @RequestMapping(path = "/test",method = RequestMethod.GET)
    public Object test(){
        return "message_detail";
    }
}
