package com.xray.oa.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class OSSUtil {

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
    private static String accessKeyId = "LTAI4GKQ5Ew9F3YqapuwBh77";
    private static String accessKeySecret = "YIPDoJgHB0fsgewcl2oqcYTJxl7Paa";
    private static String bucketName = "xxoasys";

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
        // 设置URL过期时间为100天。
        LocalDateTime time = LocalDateTime.now().plusDays(100);
        Date expiration = Date.from(time.atZone( ZoneId.systemDefault()).toInstant());
        // 生成以GET方法访问的签名URL，访客可以直接通过浏览器访问相关内容。
        URL url = ossClient.generatePresignedUrl(bucketName, objectName, expiration);
        // 关闭OSSClient。
        ossClient.shutdown();
        return url.toString();
    }
}
