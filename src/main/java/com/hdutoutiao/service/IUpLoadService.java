package com.hdutoutiao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface IUpLoadService {
    Map<String,Object> uploadImage(MultipartFile image, String remotePath);
}
