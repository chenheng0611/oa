package com.xray.oa.controller;


import com.xray.oa.service.IDepartmentService;
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
 * @since 2020-12-08
 */
@RestController
@RequestMapping("//department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(departmentService.list());
    }

}
