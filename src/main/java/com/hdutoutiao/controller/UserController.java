package com.hdutoutiao.controller;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.pojo.User;
import com.hdutoutiao.service.IUserService;
import com.hdutoutiao.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password){
        Map<String,Object> resMap = iUserService.register(username,password);
        return JsonUtil.getJsonString(resMap);
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(HttpSession session,@RequestParam("username") String username,
                        @RequestParam("password") String password){
        Map<String,Object> resMap = iUserService.login(username,password);
        User user = (User) resMap.get("user");
        if(resMap.get("code").equals(Const.ResponceCode.SUCCESS)){
             session.setAttribute("user",user);
             resMap.remove("user");
        }
        return JsonUtil.getJsonString(resMap);
    }

    @PostMapping("/logout")
    @ResponseBody
    public String loginout(HttpSession session){
        session.removeAttribute("user");
        return JsonUtil.getJsonString(Const.ResponceCode.SUCCESS);
    }

    @GetMapping("/detail/{id}")
    public String userDetail(@PathVariable("id") Integer id, Model model){
        Map<String,Object> resMap = iUserService.getUserById(id);
        if(resMap.get("code").equals(Const.ResponceCode.ERROR)){
            return "page_not_found";
        }
        model.addAttribute("other_user",resMap.get("user"));
        return "user_detail";
    }
}
