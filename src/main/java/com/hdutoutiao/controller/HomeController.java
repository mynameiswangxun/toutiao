package com.hdutoutiao.controller;

import com.hdutoutiao.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//freemarker使用https://blog.csdn.net/gebitan505/article/details/55101678
// && https://blog.csdn.net/qq_37355731/article/details/77049804
@Controller
public class HomeController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public Object index(){
//        User user = new User();
//        user.setUsername("wangxun123");
//        user.setPassword(MD5Util.MD5EncodeUtf8("wangxun123"));
//        user.setHeadImage(Integer.toString(new Random().nextInt(20)+1));
//        userMapper.insert(user);
        return "home";
    }
}
