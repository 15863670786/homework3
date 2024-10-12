package org.example.util;

import lombok.Data;


@Data
public class Result <T>{
    private Integer code;
    private String message;
    private T data;
    public static <T> Result<T> ok(T data){
        Result<T> result=new Result<>();
        result.setCode(200);
        result.setData(data);
        return result;
    }
}