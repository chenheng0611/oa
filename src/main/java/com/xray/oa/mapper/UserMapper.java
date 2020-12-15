package com.xray.oa.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xray.oa.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xray
 * @since 2020-12-13
 */
public interface UserMapper extends BaseMapper<User> {

    Page<User> selectPage(Page<User> page);
}
