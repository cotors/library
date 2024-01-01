package com.chen.controller;

import com.chen.pojo.MainMenu;
import com.chen.service.ReaderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/main")
public class MainMenuController {

    @Autowired
    private ReaderBookService readerBookService;
    @RequestMapping("/mainMenu")
    public List<MainMenu> mainMenu(){

        List<MainMenu>list=readerBookService.queryAll();

        Collections.sort(list,(o1,o2)->{
            if (o1.getCount()> o2.getCount()){
                return -1;
            }else if (o1.getCount()<o2.getCount()){
                return 1;
            }else {
                return 0;
            }
        });
        if (list.size()<=12){
            return list;
        }

        List<MainMenu>arrList=new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            arrList.add(list.get(i));
        }
        return arrList;
    }
}
