package com.example.observer;

import com.example.ConfitTank;
import com.example.MyKeyListen;
import com.example.Tank;
import com.example.TankFrame;
import com.example.strategy.DefaultBullot;

import java.awt.event.KeyEvent;

public class ControlKeyInfo implements KeyInfo{
    @Override
    public void changeDirection(MyKeyEvent myKeyEvent) {
        int key = myKeyEvent.getKeyEvent().getKeyCode();
       // MyKeyListen source = (MyKeyListen)e.getSource();
        if(KeyEvent.VK_CONTROL==key && myKeyEvent.getStates() != true){
            String bullotKey =  ConfitTank.getInfo("bullotMethod");
            if("four".equals(bullotKey)){
                //todo 一个方向打子弹
                myKeyEvent.getListen().tank.fire(DefaultBullot.getInstanceBullot());
                //todo 四个方向打子弹
                //tank.fire(FourBullot.getFourBullot());
            }
        }

    }
}
