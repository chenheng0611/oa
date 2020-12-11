package com.xray.oa.service.impl;

import com.xray.oa.entity.User;
import com.xray.oa.mapper.UserMapper;
import com.xray.oa.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xray
 * @since 2020-12-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
