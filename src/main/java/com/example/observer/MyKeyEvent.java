package com.example.observer;

import com.example.MyKeyListen;
import com.example.TankFrame;
import lombok.Data;

import java.awt.event.KeyEvent;
@Data
public class MyKeyEvent {
    private static final MyKeyEvent MY_KEY_EVENT = new MyKeyEvent();
    private MyKeyEvent(){};
    private KeyEvent keyEvent;
    private MyKeyListen listen;
    Boolean states;
    public static MyKeyEvent getMyKeyEvent(){
        return MY_KEY_EVENT;
    }
    public void initinctInfo(KeyEvent keyEvent, MyKeyListen listen ,Boolean b){
        this.keyEvent = keyEvent;
        this.listen = listen;
        states = b;
    }
}
