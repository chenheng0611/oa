package com.xray.oa.controller;

import com.xray.oa.exception.BizException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/{id}")
    public ResponseEntity findUser(@PathVariable("id") Long id){
//        int n = 10 / 0;
        if(id > 100){
            throw new BizException(404,"没有此用户");
        }
        return ResponseEntity.ok("查询到用户" + id);
    }
}
