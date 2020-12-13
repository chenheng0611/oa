package com.xray.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xray.oa.entity.Position;
import com.xray.oa.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xray
 * @since 2020-12-13
 */
@RestController
@RequestMapping("//position")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @GetMapping
    public ResponseEntity findByDeptId(Long deptId){
        return ResponseEntity.ok(positionService.list(new QueryWrapper<Position>().lambda().eq(Position::getDeptid,deptId)));
    }
}
