package com.dpc.administrator.androiddemo.bean;



/**
 * Created by Administrator on 2016/11/10.
 */
public class Customer {

    private String username;//姓名
    private String phone;//手机号码

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
