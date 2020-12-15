package com.xray.oa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xray.oa.entity.Dept;
import com.xray.oa.entity.Position;
import com.xray.oa.entity.User;
import com.xray.oa.mapper.UserMapper;
import com.xray.oa.service.IDeptService;
import com.xray.oa.service.IPositionService;
import com.xray.oa.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xray
 * @since 2020-12-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> findPage(Page<User> page) {
        return userMapper.selectPage(page);
    }

    @Override
    public User login(String username, String password) {
        User user = this.getOne(new QueryWrapper<User>().lambda().eq(User::getUserName, username));
        if(user != null){
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
