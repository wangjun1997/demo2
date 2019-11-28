package com.example.demo.controller;

import com.example.demo.entity.MyPage;
import com.example.demo.entity.TUser;
import com.example.demo.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @author wangjun
 * @name luntan
 * @time 2019/11/27 17:34
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired(required = true)
    private IUserService userService;

    @RequestMapping("/list")
    public String listStu(MyPage page, Model model){
        System.out.println(page);
        page.setUrl("user/list");
        PageInfo<TUser> lit = userService.select(page);
        System.out.println(lit);
        model.addAttribute("url","user/list");
        model.addAttribute("pageInfo",lit);
        return "list";
    }

    @RequestMapping("/lis")
    public String listStu2( Model model){

       List<TUser> lit = userService.list();
        System.out.println(lit);
        model.addAttribute("users",lit);
        return "list";
    }


    @RequestMapping("delete")
    public String delete(Long id){
        userService.removeById(id);

        return "redirect:/user/list";
    }

    @RequestMapping("toadd")
    public String toadd(){
        return "add";
    }
    @RequestMapping("addUser")
    public String addUser(TUser user){
        if(user!=null){
            user.setUserRole(Byte.valueOf("3"));
            user.setUserLevel(Byte.valueOf("8"));
            user.setGmtCreate(new Date(System.currentTimeMillis()));
            user.setGmtModified(new Date(System.currentTimeMillis()));
        }
        boolean save = userService.save(user);
        System.out.println(save);
        return "redirect:/user/list";
    }
}
