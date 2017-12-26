package com.imooc.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * create by mxy on 2017/12/18
 */
public class UserQueryCondition {

    private String name;

    @ApiModelProperty(value = "年龄起始值")
    private int age;

    @ApiModelProperty(value = "年龄终止值")
    private int ageTo;

    private String xxx;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }
}
