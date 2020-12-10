package com.xray.oa.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class OSSUtil {

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
    private static String accessKeyId = "LTAI4G3y4wYEfW2Lz8aha1eT";
    private static String accessKeySecret = "zxdF3fcCWLrUWnUwZ9QxAgYWDfaHPs";
    private static String bucketName = "chenheng0611";

    public static void upload(InputStream inputStream,String target){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, target, inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static String getURL(String objectName){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 设置URL过期时间为1小时。
        Date expiration = new Date(new Date().getTime() + 3600 * 1000);
        // 生成以GET方法访问的签名URL，访客可以直接通过浏览器访问相关内容。
        URL url = ossClient.generatePresignedUrl(bucketName, objectName, expiration);
        // 关闭OSSClient。
        ossClient.shutdown();
        return url.toString();
    }
}
