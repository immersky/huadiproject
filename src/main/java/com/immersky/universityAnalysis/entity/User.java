package com.immersky.universityAnalysis.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class User {
    private Integer user_id/*用户ID*/;
    private String user_name/*用户登录名*/;
    private String user_nickname/*用户昵称*/;
    private String user_password/*用户密码*/;
    private String user_realname/*用户姓名*/;
    private Date user_birthday/*用户生日*/;
    private Address user_address/*用户现居地*/;
    private String user_profile_picture_src/*用户头像路径*/;


    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_realname='" + user_realname + '\'' +
                ", user_birthday=" + user_birthday +
                ", user_address=" + user_address +
                ", user_profile_picture_src='" + user_profile_picture_src + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer user_id, String user_name, String user_nickname, String user_password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_nickname = user_nickname;
        this.user_password = user_password;

    }

    public User(Integer user_id, String user_name, String user_nickname, String user_password, String user_realname,Date user_birthday, Address user_address,  String user_profile_picture_src) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_nickname = user_nickname;
        this.user_password = user_password;
        this.user_realname = user_realname;
        this.user_birthday = user_birthday;
        this.user_address = user_address;
        this.user_profile_picture_src = user_profile_picture_src;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public User setUser_id(Integer user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getUser_name() {
        return user_name;
    }

    public User setUser_name(String user_name) {
        this.user_name = user_name;
        return this;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public User setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
        return this;
    }

    public String getUser_password() {
        return user_password;
    }

    public User setUser_password(String user_password) {
        this.user_password = user_password;
        return this;
    }

    public String getUser_realname() {
        return user_realname;
    }

    public User setUser_realname(String user_realname) {
        this.user_realname = user_realname;
        return this;
    }


    public String getUser_birthday() {
        if(user_birthday != null){
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
            return time.format(user_birthday);
        }
        return null;
    }

    public User setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
        return this;
    }

    public Address getUser_address() {
        return user_address;
    }

    public User setUser_address(Address user_address) {
        this.user_address = user_address;
        return this;
    }


    public String getUser_profile_picture_src() {
        return user_profile_picture_src;
    }

    public User setUser_profile_picture_src(String user_profile_picture_src) {
        this.user_profile_picture_src = user_profile_picture_src;
        return this;
    }

}
