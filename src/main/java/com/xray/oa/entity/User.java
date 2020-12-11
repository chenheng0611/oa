package com.xray.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xray
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String avatar;

    private String email;

    private Integer roleId;

    private String realname;

    private String phone;


}
