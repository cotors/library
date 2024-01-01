package com.chen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper extends BaseMapper<Book> {
}
