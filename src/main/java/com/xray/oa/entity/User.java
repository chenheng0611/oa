package com.xray.oa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xray
 * @since 2020-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    private String address;

    private String bank;

    private LocalDate birth;

    private String email;

    private Long fatherId;

    private LocalDate hireTime;

    private String userIdcard;

    private String imgPath;

    private Integer isLock;

    private String lastLoginIp;

//    private String lastLoginTime;

//    private String modifyTime;

    private Long modifyUserId;

    private String password;

    private String realName;

    private Float salary;

    private String userSchool;

    private String sex;

    private String themeSkin;

    private String userEdu;

    private String userName;

    private String userSign;

    private String userTel;

    private Long deptId;

    private Long positionId;

    private Long roleId;

    private Integer superman;

    private Integer holiday;

    private String pinyin;

    @TableField(exist = false)
    private String deptName;

    @TableField(exist = false)
    private String positionName;
}
