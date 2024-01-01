package com.chen.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.chen.pojo.Book;
import com.chen.pojo.Type;
import com.chen.service.BookService;
import com.chen.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private BookService bookService;

    @RequestMapping("listType")
    public String listType(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize, Model model, Type type){
        if (pageNum<0||pageNum.equals("")||pageNum==null){
            pageNum=1;
        }
        if (pageSize<0||pageSize.equals("")||pageSize==null){
            pageSize=10;
        }

        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Type>qw=new QueryWrapper<>();
        if (type.getType()!=null){
            qw.like("type",type.getType());
        }
        List<Type> list = typeService.list(qw);
        PageInfo<Type>pageInfo=new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "typeList";
    }

    @RequestMapping("preSaveType")
    public String preSaveType(){
        return "typeSave";
    }

    @RequestMapping("saveType")
    public String saveType(Type type){
        boolean save = typeService.save(type);
        return "redirect:/type/listType";
    }

    @RequestMapping("preUpdateType/{id}")
    public String preUpdateType(@PathVariable Integer id,Model model){
        Type type = typeService.getById(id);
        model.addAttribute("type",type);
        return "typeUpdate";
    }

    @RequestMapping("updateType")
    public String updateType(Type type){
        boolean b = typeService.updateById(type);
        return "redirect:/type/listType";
    }

    @RequestMapping("delType/{id}")
    public String delType(@PathVariable Integer id){
        boolean b = typeService.removeById(id);
        return "redirect:/type/listType";
    }

    @RequestMapping("batchDeleteType")
    @ResponseBody
    public String batchDeleteType(String idList){
        String[] split = StrUtil.split(idList, ",");
        List<Integer>list=new ArrayList<>();
        for (String s : split) {
            if (!s.isEmpty()){
                int i = Integer.parseInt(s);
                list.add(i);
            }
        }
        boolean b = typeService.removeByIds(list);
        if (b){
            return "OK";
        }else {
            return "error";
        }
    }

    @RequestMapping("bookList/{type}")
    public String bookList(@PathVariable String type,
                           @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize, HttpSession session, Model model){
        if (pageNum<0||pageNum.equals("")||pageNum==null){
            pageNum=1;
        }
        if (pageSize<0||pageSize.equals("")||pageSize==null){
            pageSize=10;
        }

        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Book>qw=new QueryWrapper<>();
        qw.eq("type",type);
        List<Book> list = bookService.list(qw);
        PageInfo<Book>pageInfo=new PageInfo<>(list);
        session.setAttribute("type",type);
        model.addAttribute("pageInfo",pageInfo);
        return "typeBookList";
    }
}
