package com.example.demo.exceptionhandler;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
public class DiyException extends RuntimeException {
    private Integer code;//状态马
    private String msg;//状态信息
}
