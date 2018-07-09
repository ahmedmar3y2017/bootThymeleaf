package com.example.demo;

import com.example.demo.Entities.person;

import java.util.List;

public class AjaxResponseBody {

    String msg;
    List<person> result;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<person> getResult() {
        return result;
    }

    public void setResult(List<person> result) {
        this.result = result;
    }
}
