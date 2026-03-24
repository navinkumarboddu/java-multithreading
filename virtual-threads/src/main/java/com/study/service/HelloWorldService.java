package com.study.service;


import com.study.util.CommonUtil;

public class HelloWorldService {

    public String hello(){
        CommonUtil.sleep(1000);
        return "Hello";
    }

    public String world(){
        CommonUtil.sleep(1000);
        return " World";
    }
}
