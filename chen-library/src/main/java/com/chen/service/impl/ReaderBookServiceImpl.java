package com.chen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.chen.mapper.ReaderBookMapper;
import com.chen.pojo.Book;
import com.chen.pojo.MainMenu;
import com.chen.pojo.ReaderBook;
import com.chen.service.ReaderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderBookServiceImpl extends ServiceImpl<ReaderBookMapper, ReaderBook> implements ReaderBookService {

    @Autowired
    private ReaderBookMapper readerBookMapper;
    @Override
    public PageInfo<ReaderBook> listAll(String readerName) {
        List<ReaderBook>list=readerBookMapper.listAll(readerName);
        return new PageInfo<>(list);
    }

    @Override
    public List<MainMenu> queryAll() {
        return readerBookMapper.queryAll();
    }

    @Override
    public PageInfo<Book> myBookList(Integer userId) {
        List<Book>list=readerBookMapper.myBookList(userId);
        return new PageInfo<>(list);
    }
}
