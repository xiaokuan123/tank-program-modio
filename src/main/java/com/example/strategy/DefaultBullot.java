package com.example.strategy;

import com.example.Audio;
import com.example.Bullot;
import com.example.Group;
import com.example.Tank;
import com.example.factory.BaseFactory;

public class DefaultBullot implements StrategyFactory {
   private DefaultBullot(){};
   private static final DefaultBullot DEFAULTBULLOT = new DefaultBullot();

    @Override
    public void fire(Tank tank, BaseFactory baseFactory) {
        int xk =tank.getX()+ Tank.T_WIDTH /2 - Bullot.B_WIDTH/2;
        int yk =tank.getY() + Tank.T_THINTH /2 - Bullot.B_THINTH/2;
        //todo 用抽象工厂的方式生产子弹
        baseFactory.getWeaponBullet(xk,yk,tank.getDir(),tank.getTankFrame(), Group.GOOD.getCode());
       // new Bullot();
        //todo 打子弹的声音
        new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    public static DefaultBullot getInstanceBullot(){
        return DEFAULTBULLOT;
    }
}
