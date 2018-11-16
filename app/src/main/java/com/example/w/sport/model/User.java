package com.example.w.sport.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by w on 2018/11/14.
 */
public class User extends BmobObject {

    private String phone;
    private String username;
    private String password;
    private String sex;
    private Integer age;

//    public User(){
//        this.setTableName("_User");
//    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
