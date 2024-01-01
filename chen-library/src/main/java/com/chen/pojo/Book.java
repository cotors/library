package com.chen.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book")
public class Book {
    private Integer id;
    private String bname;
    private String type;
    private String author;
    private Integer stock;
    private String language;
    private String bimage;
}
