package com.xray.oa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xray.oa.entity.Department;
import com.xray.oa.entity.Employee;
import com.xray.oa.entity.Job;
import com.xray.oa.mapper.EmployeeMapper;
import com.xray.oa.service.IDepartmentService;
import com.xray.oa.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xray.oa.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xray
 * @since 2020-12-08
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IJobService jobService;

    @Override
    public List<Employee> findAll() {
        List<Employee> list = this.list();
        for(Employee employee : list){
            Department dep = departmentService.getById(employee.getDepId());
            Job job = jobService.getById(employee.getJobId());
            employee.setDepartment(dep);
            employee.setJob(job);
        }
        return list;
    }

    @Override
    public Page<Employee> findPage(Long current) {
        if(current == null){
            current = 1L;
        }
        Page<Employee> pageArg = new Page<>(current, 10);
        Page<Employee> page = this.page(pageArg);
        for(Employee employee : page.getRecords()){
            Department dep = departmentService.getById(employee.getDepId());
            Job job = jobService.getById(employee.getJobId());
            employee.setDepartment(dep);
            employee.setJob(job);
        }
        return page;
    }
}
