package com.hdutoutiao.controller;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.pojo.User;
import com.hdutoutiao.service.IUpLoadService;
import com.hdutoutiao.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class UploadConroller {

    @Autowired
    IUpLoadService iUpLoadService;

    @PostMapping("/newsImage")
    @ResponseBody
    public String uploadImage(HttpSession session, @RequestParam(value = "file",required = false) MultipartFile image){
        User user = (User) session.getAttribute("user");
        if(user==null){
            return JsonUtil.getJsonString(Const.ResponceCode.ERROR,"用户未登录，无法上传图片");
        }
        Map<String,Object> resMap = iUpLoadService.uploadImage(image,"/news");
        return JsonUtil.getJsonString(resMap);
    }
}
