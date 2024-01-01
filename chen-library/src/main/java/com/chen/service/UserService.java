package com.chen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.pojo.User;

public interface UserService extends IService<User> {
    boolean login(String userName, String userPwd);
}
