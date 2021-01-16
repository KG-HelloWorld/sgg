package com.example.mydemo.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class User {
    private long id;
    private String name;
    private Integer age;
    private String email;

    @Version
    private Integer version;
}
