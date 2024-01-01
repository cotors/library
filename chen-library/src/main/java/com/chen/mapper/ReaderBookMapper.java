package com.chen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.Book;
import com.chen.pojo.MainMenu;
import com.chen.pojo.ReaderBook;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderBookMapper extends BaseMapper<ReaderBook> {
     List<ReaderBook> listAll(String readerName);

    List<MainMenu> queryAll();

    List<Book> myBookList(Integer userId);
}
