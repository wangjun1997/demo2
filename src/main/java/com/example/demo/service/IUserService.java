package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.MyPage;
import com.example.demo.entity.TUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author wangjun
 * @name luntan
 * @time 2019/11/27 17:52
 */
public interface IUserService extends IService<TUser> {
    PageInfo<TUser> select(MyPage page);

    List<TUser> select2();
}
