package com.hdutoutiao.service.impl;

import com.hdutoutiao.common.Const;
import com.hdutoutiao.service.IUpLoadService;
import com.hdutoutiao.util.FTPUtil;
import com.hdutoutiao.util.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service("iUploadService")
public class UploadServiceImpl implements IUpLoadService{
    @Override
    public Map<String,Object> uploadImage(MultipartFile image,String remotePath){
        Map<String,Object> resMap = new HashMap<>();
        if(image==null){
            resMap.put("code", Const.ResponceCode.ERROR);
            resMap.put("msg", "请上传图片文件！");
            return resMap;
        }
        String imageName = image.getOriginalFilename();
        String postfix = imageName.substring(imageName.lastIndexOf(".")+1);
        //判断后缀名是否符合要求
        boolean flag = false;
        for(String picPostFix : Const.PIC_POSTFIX){
            if(postfix.equals(picPostFix)){
                flag = true;
                break;
            }
        }
        if(!flag){
            resMap.put("code", Const.ResponceCode.ERROR);
            resMap.put("msg", "文件后缀名不符合要求");
            return resMap;
        }
        String uploadFileName =  UUID.randomUUID().toString() + "." + postfix;
        log.info("开始上传文件,上传文件的文件名:{},新文件名:{}",imageName,uploadFileName);
        Boolean isUploadSuc = true;
        try {
            isUploadSuc = FTPUtil.uploadFile(uploadFileName,image.getInputStream(),"/"+remotePath);
        } catch (IOException e) {
            log.error("上传文件失败",e);
            isUploadSuc = false;
        }
        if(!isUploadSuc){
            resMap.put("code", Const.ResponceCode.ERROR);
            resMap.put("msg", "上传图片失败！");
            return resMap;
        }
        resMap.put("code",Const.ResponceCode.SUCCESS);
        resMap.put("msg",PropertiesUtil.getProperty("url.image.prefix")+remotePath+"/"+uploadFileName);
        return resMap;
    }
}
