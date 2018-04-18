package com.hdutoutiao.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class FTPUtil {

    private static String ftpIp = PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser = PropertiesUtil.getProperty("ftp.user");
    private static String ftpPass = PropertiesUtil.getProperty("ftp.pass");

    public static boolean uploadFile(String remoteFileName, InputStream fileInputStream, String remotePath) throws IOException {
        boolean isUploadSec = true;
        FTPClient ftpClient = new FTPClient();
        log.info("开始连接ftp服务器");
        ftpClient.connect(ftpIp);
        boolean isConnectSuc = ftpClient.login(ftpUser,ftpPass);
        if(!isConnectSuc){
            log.warn("ftp服务器连接失败，请检查ip地址是否正确，或者用户密码是否正确！");
            return false;
        }
        try{
            ftpClient.changeWorkingDirectory(remotePath);
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.storeFile(remoteFileName,fileInputStream);
        }catch (Exception e){
            log.error("上传异常",e);
            isUploadSec = false;
        }finally {
            fileInputStream.close();
            ftpClient.disconnect();
        }
        return isUploadSec;
    }

}
