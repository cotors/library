package com.chen.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    private Integer id;
    private String email;
    private String password;
    private String username;
    private String phone;
    private String image;
}
