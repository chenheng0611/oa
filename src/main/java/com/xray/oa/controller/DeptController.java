package com.xray.oa.controller;


import com.xray.oa.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xray
 * @since 2020-12-13
 */
@RestController
@RequestMapping("//dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(deptService.list());
    }
}
