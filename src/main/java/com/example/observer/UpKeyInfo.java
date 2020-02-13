package com.example.observer;

import com.example.MyKeyListen;
import com.example.Tank;
import com.example.TankFrame;

import java.awt.event.KeyEvent;

public class UpKeyInfo implements KeyInfo{
    @Override
    public void changeDirection(MyKeyEvent myKeyEvent) {
        int key = myKeyEvent.getKeyEvent().getKeyCode();
        MyKeyListen source = myKeyEvent.getListen();
        System.out.println("==============="+source.VL);
        if(KeyEvent.VK_UP == key){
        source.VU = myKeyEvent.getStates();
        }

    }
}
