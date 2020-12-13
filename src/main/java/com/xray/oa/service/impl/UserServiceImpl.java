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
    private IDeptService deptService;

    @Autowired
    private IPositionService positionService;

    @Override
    public Page<User> findPage(Long current) {
        if(current == null){
            current = 1L;
        }
        Page<User> pageArg = new Page<>(current, 10);
        Page<User> result = this.page(pageArg);
        for(User user : result.getRecords()){
            Dept dept = deptService.getById(user.getDeptId());
            Position position = positionService.getById(user.getPositionId());
            user.setDeptName(dept.getDeptName());
            user.setPositionName(position.getName());
        }
        return result;
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
