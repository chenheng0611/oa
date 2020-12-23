package com.xray.oa.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xray.oa.entity.User;
import com.xray.oa.exception.BizException;
import com.xray.oa.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xray
 * @since 2020-12-13
 */
@Slf4j
@RestController
@RequestMapping("//user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/page/{current}")
    public ResponseEntity findPage(@PathVariable(value = "current",required = false)Long current){
        if(current == 9){
            current = 1L;
        }
        Page<User> page = new Page<>(current, 10);
        page = userService.findPage(page);
        if(page.getRecords().isEmpty()){
            throw new BizException(404,"找不到员工信息");
        }
        return ResponseEntity.ok(page);
    }
    
    @PostMapping("/login")
    public ResponseEntity login(String username,String password){
        User user = userService.login(username, password);
        if(user == null){
            throw new BizException(404,"找不到员工信息");
        }
        return ResponseEntity.ok(user);
    }


    @PostMapping
    public ResponseEntity saveUser(@RequestBody User User){
        userService.save(User);
        return ResponseEntity.ok(User);
    }

    @PutMapping
    public ResponseEntity updateUser(User User){
        userService.updateById(User);
        return ResponseEntity.ok(User);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id")Long id){
        userService.removeById(id);
        return ResponseEntity.ok(id);
    }
}
