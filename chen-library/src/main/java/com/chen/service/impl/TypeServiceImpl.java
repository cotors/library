package com.chen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.mapper.TypeMapper;
import com.chen.pojo.Type;
import com.chen.service.TypeService;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper , Type>implements TypeService {
}
