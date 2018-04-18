package com.hdutoutiao.service.impl;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.dao.UserMapper;
import com.hdutoutiao.pojo.User;
import com.hdutoutiao.service.IUserService;
import com.hdutoutiao.util.MD5Util;
import com.hdutoutiao.util.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Slf4j
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String,Object> register(String username, String password) {

        Map<String,Object> map = new HashMap<>();

        if(StringUtils.isEmpty(username)){
            map.put("code",Const.ResponceCode.ERROR);
            map.put("msgname","用户名不能为空！");
            return map;
        }
        if(StringUtils.isEmpty(password)){
            map.put("code",Const.ResponceCode.ERROR);
            map.put("msgpwd","密码不能为空！");
            return map;
        }
        if(username.trim().length()>20){
            map.put("code",Const.ResponceCode.ERROR);
            map.put("msgname","用户名长度不能超过20！");
            return map;
        }
        if(password.trim().length()>20){
            map.put("code",Const.ResponceCode.ERROR);
            map.put("msgpwd","密码长度不能超过20！");
            return map;
        }
        if(userMapper.selectByUsername(username)!=null){
            map.put("code",Const.ResponceCode.ERROR);
            map.put("msgname","用户名已经存在！");
            return map;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(MD5Util.MD5EncodeUtf8(password));
        user.setHeadImage(PropertiesUtil.getProperty("url.image.prefix")+"/user/"+Integer.toString(new Random().nextInt(10)+1)+".png");
        try {
            userMapper.insert(user);
        }catch (Exception e){
            log.error("插入新用户失败",e.getMessage());
            map.put("code",Const.ResponceCode.ERROR);
            map.put("msgpwd","注册失败，服务器异常！");
            return map;
        }
        map.put("code",Const.ResponceCode.SUCCESS);
        return map;
    }

    @Override
    public Map<String,Object> login(String username, String password) {

        Map<String,Object> map = new HashMap<>();

        if(StringUtils.isEmpty(username)){
            map.put("code",Const.ResponceCode.ERROR);
            map.put("msgname","用户名不能为空！");
            return map;
        }
        if(StringUtils.isEmpty(password)){
            map.put("code",Const.ResponceCode.ERROR);
            map.put("msgpwd","密码不能为空！");
            return map;
        }
        User user = userMapper.selectByUsername(username);
        if(user==null){
            map.put("code",Const.ResponceCode.ERROR);
            map.put("msgname","用户名不存在！");
            return map;
        }
        if(!MD5Util.MD5EncodeUtf8(password).equals(user.getPassword())){
            map.put("code",Const.ResponceCode.ERROR);
            map.put("msgpwd","密码错误！");
            return map;
        }
        user.setPassword("");
        map.put("code",Const.ResponceCode.SUCCESS);
        map.put("user",user);
        return map;
    }
}
