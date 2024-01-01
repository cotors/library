package com.chen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.chen.pojo.Book;
import com.chen.pojo.MainMenu;
import com.chen.pojo.ReaderBook;

import java.util.List;

public interface ReaderBookService extends IService<ReaderBook> {
    PageInfo<ReaderBook> listAll(String readerName);

     List<MainMenu> queryAll();

    PageInfo<Book> myBookList(Integer userId);
}
