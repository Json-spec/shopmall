package com.shopMallProject.common.result;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * description: ResultConfig <br>
 * date: 2020/11/2 15:22 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
@Data
@NoArgsConstructor          //lombok中无参构造方法
@ToString                   //toString方法
public class ResultConfig<T> {
    private Integer code;
    private String message;
    private T data;

    public ResultConfig(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultConfig(Integer code, String message) {
        this.code=code;
        this.message=message;
    }
}