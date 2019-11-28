package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.TUser;

import java.util.List;


/**
 * @author wangjun
 * @name luntan
 * @time 2019/11/27 17:57
 */

public interface UserMapper  extends BaseMapper<TUser> {
    List<TUser> getUserList();
}
