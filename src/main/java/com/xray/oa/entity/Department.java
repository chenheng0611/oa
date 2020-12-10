package com.xray.oa.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-12-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    private String name;

    private Integer parentId;


}
