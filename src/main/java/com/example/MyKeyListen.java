package com.example;

import com.example.factory.BaseFactory;
import com.example.observer.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static com.example.Dir.*;
import static com.example.Dir.DOWN;

public class MyKeyListen extends KeyAdapter {
    private static final MyKeyListen MYLISTEN = new MyKeyListen();

    private MyKeyListen() {}

    public Tank tank;
    //todo 观察者模式应用
    private static List<KeyInfo> keyInfoList = new ArrayList<>();

    static {
        //todo 观察者模式应用
        keyInfoList.add(new LeftKeyInfo());
        keyInfoList.add(new RightKeyInfo());
        keyInfoList.add(new UpKeyInfo());
        keyInfoList.add(new DownKeyInfo());
        keyInfoList.add(new ControlKeyInfo());
    }

    public Boolean VL = false;
    public Boolean VR = false;
    public Boolean VU = false;
    public Boolean VD = false;

    public static MyKeyListen getMylisten() {
        return MYLISTEN;
    }
    public void setTank(Tank tank) {
       this.tank =tank;
    }

    @Override
    public void keyPressed(KeyEvent e) {
         MyKeyEvent.getMyKeyEvent().initinctInfo(e,this,true);

        for (int i = 0; i < keyInfoList.size(); i++) {
            //todo 观察者模式
            keyInfoList.get(i).changeDirection(MyKeyEvent.getMyKeyEvent());
        }
           /* int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    VL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    VR = true;
                    break;
                case KeyEvent.VK_UP:
                    VU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    VD = true;
                    break;
                default:
                    break;
            }
            ;*/
        setKeytank();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        MyKeyEvent.getMyKeyEvent().initinctInfo(e,this,false);
        for (int i = 0; i < keyInfoList.size(); i++) {
            //todo 观察者模式
            keyInfoList.get(i).changeDirection(MyKeyEvent.getMyKeyEvent());
        }
          /* int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    VL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    VR = false;
                    break;
                case KeyEvent.VK_UP:
                    VU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    VD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    // VD = false;
                    //tank.makerBullot();
                    //todo 策略模式调试
                 *//* String bullotKey =  ConfitTank.getInfo("defaultFour");
                   try {
                       try {
                            factory =(StrategyFactory)Class.forName(bullotKey).newInstance();
                       } catch (InstantiationException ex) {
                           ex.printStackTrace();
                       } catch (IllegalAccessException ex) {
                           ex.printStackTrace();
                       }
                   } catch (ClassNotFoundException ex) {
                       ex.printStackTrace();
                   }
                   tank.fire(factory);*//*
                    //todo 非反射的方法
                    String bullotKey = ConfitTank.getInfo("bullotMethod");
                    //System.out.println(bullotKey);
                    if ("four".equals(bullotKey)) {
                        //todo 一个方向打子弹
                        tank.fire(DefaultBullot.getInstanceBullot());
                        //todo 四个方向打子弹
                        //tank.fire(FourBullot.getFourBullot());
                    }
                    break;
                default:
                    break;
            }*/

        setKeytank();
    }

    public void setKeytank() {
        if (!VL && !VR && !VU && !VD) {
            tank.setMoveing(false);
        } else {
            tank.setMoveing(true);
            if (VL) {
                tank.setDir(LIFT);
            }
            ;
            if (VR) {
                tank.setDir(RIGHT);
            }
            ;
            if (VU) {
                tank.setDir(UP);
            }
            ;
            if (VD) {
                tank.setDir(DOWN);
            }
        }


    }
}
