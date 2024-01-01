package com.chen.controller;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.chen.pojo.Book;
import com.chen.pojo.Reader;
import com.chen.pojo.ReaderBook;
import com.chen.service.BookService;
import com.chen.service.ReaderBookService;
import com.chen.service.ReaderService;
import com.chen.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("readerBook")
public class ReaderBookController {

    @Autowired
    private ReaderService readerService;
    @Autowired
    private BookService bookService;
    @Autowired
    private ReaderBookService readerBookService;

    @RequestMapping("listReaderBook")
    public String listReaderBook(@RequestParam(required = false,value = "pageNum",defaultValue = "1")Integer pageNum,
                                 @RequestParam(required = false,value = "pageSize",defaultValue = "10")Integer pageSize, String readerName,
                                 Model model){
        if (pageNum<0 || pageNum.equals("") || pageNum==null){
            pageNum=1;
        }
        if (pageSize<0||pageSize.equals("")||pageSize==null){
            pageSize=10;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<ReaderBook>pageInfo=readerBookService.listAll(readerName);
        model.addAttribute("pageInfo",pageInfo);
        return "borrowList";
    }

    @RequestMapping("preBorrow")
    public String preBorrow(Model model){
        List<Reader> readerList = readerService.list(null);
        List<Book> bookList = bookService.list(null);
        model.addAttribute("readerList",readerList);
        model.addAttribute("bookList",bookList);
        return "borrowSave";
    }

    @RequestMapping("saveReaderBook")
    public String saveReaderBook(Integer readerId,Integer bookId){
        ReaderBook readerBook = new ReaderBook();
        readerBook.setRid(readerId);
        readerBook.setBid(bookId);
        readerBookService.save(readerBook);
        Book book = bookService.getById(bookId);
        book.setStock(book.getStock()-1);
        bookService.updateById(book);
        return "redirect:/readerBook/listReaderBook";
    }

    @RequestMapping("batchReturnReaderBook")
    @ResponseBody
    public String batchReturnReaderBook(String idList){
        String[] split = StrUtil.split(idList, ",");
        List<ReaderBook>list=new ArrayList<>();
        for (String s : split) {
            if (!s.isEmpty()){
                int i = Integer.parseInt(s);
                ReaderBook readerBook = new ReaderBook();
                readerBook.setId(i);
                readerBook.setStatus(1);
                list.add(readerBook);
                Book book = bookService.getById(readerBookService.getById(i).getBid());
                book.setStock(book.getStock()+1);
                bookService.updateById(book);
            }
        }
        boolean b = readerBookService.updateBatchById(list);
        if (b){
            return "OK";
        }else {
            return "error";
        }
    }

    @RequestMapping("batchDeleteReaderBook")
    @ResponseBody
    public String batchDeleteReaderBook(String idList){
        String[] split = StrUtil.split(idList, ",");
        List<Integer>list=new ArrayList<>();
        for (String s : split) {
            if (!s.isEmpty()){
                Integer integer = Integer.valueOf(s);
                list.add(integer);
            }
        }
        boolean b = readerBookService.removeByIds(list);
        if (b){
            return "OK";
        }else {
            return "error";
        }
    }

    @RequestMapping("delReaderBook/{id}")
    public String delReaderBook(@PathVariable Integer id){
        boolean b = readerBookService.removeById(id);
        return "redirect:/readerBook/listReaderBook";
    }

    @RequestMapping("sendEmail/{email}/{bname}")
    public String sendEmail(@PathVariable String email,@PathVariable String bname){
        MailUtils.sendMail(email,"请在规定时间内归还图书《"+bname+"》"+"<a href='http://localhost:8088'>去还书</a>","图书馆邮件");
        return "redirect:/readerBook/listReaderBook";
    }
}
