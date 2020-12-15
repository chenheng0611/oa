package com.xray.oa.entity;

import lombok.Data;

@Data
public class UserVO extends User {

    private String deptName;

    private String positionName;
}
