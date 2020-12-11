package com.xray.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xray.oa.entity.User;
import com.xray.oa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xray
 * @since 2020-12-11
 */
@RestController
@RequestMapping("//user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public ResponseEntity login(String username,String password){
        User user = userService.getOne(new QueryWrapper<User>().lambda().eq(User::getUsername, username));
        if(user != null){
            if(user.getPassword().equals(password)){
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.ok(null);
    }
}
