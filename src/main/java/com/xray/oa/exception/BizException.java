package com.xray.oa.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 业务异常
 */
@Data
public class BizException extends RuntimeException {

    private Integer code;
    private String msg;

    public BizException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }

    public BizException(String msg) {
        super(msg);
    }

    public BizException() {
        super("未知业务异常");
    }
}
