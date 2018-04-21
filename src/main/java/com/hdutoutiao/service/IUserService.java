package com.hdutoutiao.service;

import java.util.Map;

public interface IUserService {

    Map<String,Object> register(String username, String password);

    Map<String,Object> login(String username, String password);

    Map<String,Object> getUserById(Integer id);

}
