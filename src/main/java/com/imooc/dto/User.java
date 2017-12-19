package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * create by mxy on 2017/12/18
 */
public class User {

    public interface UserSimpleView{};

    public interface UserDetailView extends UserSimpleView{};

    private String name;
    private String passWord;

    @JsonView(UserSimpleView.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(UserDetailView.class)
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


}
