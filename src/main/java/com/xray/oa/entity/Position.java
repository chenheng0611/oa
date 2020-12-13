package com.xray.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@TableName("t_position")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "position_id", type = IdType.AUTO)
    private Long positionId;

    private Integer level;

    private String name;

    private String describtion;

    private Long deptid;


}
