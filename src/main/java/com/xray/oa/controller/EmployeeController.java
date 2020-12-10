package com.xray.oa.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xray.oa.entity.Employee;
import com.xray.oa.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xray
 * @since 2020-12-08
 */
@Slf4j
@RestController
@RequestMapping("//employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity list(){
        try {
            List<Employee> list = employeeService.findAll();
            if(list.isEmpty()){
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            log.error("exception:",e);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/page/{current}")
    public ResponseEntity findPage(@PathVariable(value = "current",required = false)Long current){
        try {
            Page<Employee> page = employeeService.findPage(current);
            if(page.getTotal() == 0){
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(page);
        } catch (Exception e) {
            log.error("exception:",e);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
