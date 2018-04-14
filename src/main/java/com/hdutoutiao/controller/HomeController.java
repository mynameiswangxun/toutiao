package com.hdutoutiao.controller;

import com.hdutoutiao.dao.UserMapper;
import com.hdutoutiao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

//freemarker使用https://blog.csdn.net/gebitan505/article/details/55101678
// && https://blog.csdn.net/qq_37355731/article/details/77049804
@Controller
public class HomeController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user!=null){
            model.addAttribute("user",user);
        }
        return "home";
    }
}
