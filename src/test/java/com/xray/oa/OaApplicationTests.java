package com.xray.oa;

import com.xray.oa.entity.Employee;
import com.xray.oa.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OaApplicationTests {

    @Autowired
    private IEmployeeService employeeService;

    @Test
    void contextLoads() {

        for (int i = 2; i < 200; i++) {
            Employee employee = new Employee(Long.valueOf(i),"测试"+i,20+i,i%2==0?"男":"女","18000000001","135232@qq.com","xxx",6,6,"xx.jpg",null,null);
            employeeService.save(employee);
        }
    }

}
