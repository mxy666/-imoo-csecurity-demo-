package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

/**
 * create by mxy on 2017/12/18
 */


@RestController
public class UserController {

    @GetMapping("/user")
    @JsonView(User.UserSimpleView.class)
    public List<User> query(@RequestParam(name = "nickName",required = false,defaultValue = "tom") String name){
   // public List<User> query(UserQueryCondition condition, Pageable pageable) {
        System.out.println(name);
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/user/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id) {
        User user = new User();
        user.setName("tom");
        return user;

    }


}
