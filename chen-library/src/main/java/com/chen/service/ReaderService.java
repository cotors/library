package com.chen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.pojo.Reader;

public interface ReaderService extends IService<Reader> {
    boolean login(String userName, String userPwd);
}
