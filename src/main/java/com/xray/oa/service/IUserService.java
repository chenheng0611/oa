package com.xray.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xray.oa.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xray
 * @since 2020-12-13
 */
public interface IUserService extends IService<User> {

    Page<User> findPage(Page<User> page);

    User login(String username,String password);
}
