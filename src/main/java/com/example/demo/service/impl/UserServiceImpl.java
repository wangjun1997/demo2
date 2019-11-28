package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.MyPage;
import com.example.demo.entity.TUser;
import com.example.demo.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangjun
 * @name luntan
 * @time 2019/11/27 17:53
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TUser> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<TUser> select(MyPage page) {
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<TUser> userList = userMapper.getUserList();
        return new PageInfo<>(userList);
    }

    @Override
    public List<TUser> select2() {
        return userMapper.getUserList();
    }
}
