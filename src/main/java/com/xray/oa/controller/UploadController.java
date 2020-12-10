package com.xray.oa.controller;

import com.xray.oa.util.OSSUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("//image")
public class UploadController {

    @PostMapping("upload")
    public ResponseEntity upload(MultipartFile file){
        try {
            String filename = file.getOriginalFilename();
            OSSUtil.upload(file.getInputStream(), "images/" + filename);
            String url = OSSUtil.getURL("images/" + filename);
            return ResponseEntity.ok(url);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
