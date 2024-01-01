package com.chen.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("reader_book")
public class ReaderBook {
    @TableId
    private Integer id;
    private Integer rid;
    private Integer bid;
    private Integer status;
    @TableField(fill = FieldFill.INSERT)
    private Date borrowTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date returnTime;
    @TableField(exist = false)
    private Reader reader;
    @TableField(exist = false)
    private Book book;
}
