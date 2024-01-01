package com.chen.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("type")
public class Type {

    private Integer id;
    private String type;
    private String feature;




}
