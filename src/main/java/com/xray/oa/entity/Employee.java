package com.xray.oa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author xray
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    private String name;

    private Integer age;

    private String gender;

    private String phone;

    private String email;

    private String address;

    private Integer jobId;

    private Integer depId;

    private String picture;

    @TableField(exist = false)
    private String job;

    @TableField(exist = false)
    private String department;
}
