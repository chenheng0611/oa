package com.xray.oa.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xray.oa.entity.User;
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
        try {
            Page<User> page = userService.findPage(current);
            if(page.getTotal() == 0){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(page);
        } catch (Exception e) {
            log.error("exception:",e);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PostMapping("/login")
    public ResponseEntity login(String username,String password){
        try {
            User user = userService.login(username, password);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            log.error("exception:",e);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping
    public ResponseEntity saveUser(@RequestBody User User){
        try {
            userService.save(User);
            return ResponseEntity.ok(User);
        } catch (Exception e) {
            log.error("exception:",e);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity updateUser(User User){
        try {
            userService.updateById(User);
            return ResponseEntity.ok(User);
        } catch (Exception e) {
            log.error("exception:",e);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id")Long id){
        try {
            userService.removeById(id);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            log.error("exception:",e);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
