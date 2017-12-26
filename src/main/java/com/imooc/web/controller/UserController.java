package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.exception.UserNotExistException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * create by mxy on 2017/12/18
 */


@RestController
@RequestMapping("/user")
public class UserController {


    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable int id) {
        System.out.println("delete :" + id);
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));

        }
        System.out.println("-------user===");
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassWord());
        System.out.println(user.getBirthday());
        user.setId(1);
        return user;
    }


    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
//                            FieldError fieldError=(FieldError)error;
//                            String meaasge=fieldError.getField()+"-->"+error.getDefaultMessage();
                System.out.println(error.getDefaultMessage());
            });

        }
        System.out.println("-------user===");
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassWord());
        System.out.println(user.getBirthday());
        user.setId(1);
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public List<User> query(@RequestParam(name = "nickName", required = false, defaultValue = "tom") String name) {
        // public List<User> query(UserQueryCondition condition, Pageable pageable) {
        System.out.println(name);
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam(value = "用户id") @PathVariable String id) {
        System.out.println("进入getInfo服务");

        User user = new User();
        user.setName("tom");
        return user;
        // throw new UserNotExistException(id);

    }


}
