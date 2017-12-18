package com.imooc.web.controller;

import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.bind.annotation.*;
import sun.reflect.ReflectionFactory;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

/**
 * create by mxy on 2017/12/18
 */


@RestController

public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    // public List<User> query(@RequestParam(name = "nickName",required = false,defaultValue = "tom") String userName){
    public List<User> query(UserQueryCondition condition, Pageable pageable) {

        List<User> users = new ArrayList<>();
        System.out.println(condition.toString());
        System.out.println(pageable.toString());
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.GET)
    public User getInfo(@PathVariable String id) {
        User user = new User();
        user.setName("tom");
        return user;

    }


}
