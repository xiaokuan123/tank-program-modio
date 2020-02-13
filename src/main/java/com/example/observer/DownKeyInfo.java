package com.example.observer;

import com.example.MyKeyListen;
import com.example.Tank;
import com.example.TankFrame;

import java.awt.event.KeyEvent;

public class DownKeyInfo implements KeyInfo{
    @Override
    public void changeDirection(MyKeyEvent myKeyEvent) {
        int key = myKeyEvent.getKeyEvent().getKeyCode();
        MyKeyListen source = myKeyEvent.getListen();
        if(KeyEvent.VK_DOWN==key){
          source.VD =  myKeyEvent.getStates();
        }

    }
}
