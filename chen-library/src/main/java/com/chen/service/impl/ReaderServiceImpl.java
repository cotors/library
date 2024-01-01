package com.chen.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.mapper.ReaderMapper;
import com.chen.pojo.Reader;
import com.chen.service.ReaderService;
import org.springframework.stereotype.Service;

@Service
public class ReaderServiceImpl extends ServiceImpl<ReaderMapper, Reader>implements ReaderService {

    @Override
    public boolean login(String userName, String userPwd) {
        QueryWrapper<Reader> qw=new QueryWrapper<>();
        qw.eq("rname",userName);
        Reader reader = this.baseMapper.selectOne(qw);
        if (reader==null){
            return false;
        }
        String s = DigestUtil.md5Hex(userPwd);
        if (s.equals(reader.getPassword())){
            return true;
        }else {
            return false;
        }
    }
}
