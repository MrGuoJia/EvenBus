package com.example.jia.evenbus;

/**
 * Created by jia on 2017/4/5.
 */

public class Event {
    private String mMsg;
    public  Event(String mMsg){
        this.mMsg=mMsg;
    }
    public String getMsg(){
        return mMsg;
    }
}
