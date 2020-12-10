package com.xray.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xray.oa.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xray
 * @since 2020-12-08
 */
public interface IEmployeeService extends IService<Employee> {

    List<Employee> findAll();

    Page<Employee> findPage(Long current);

}
