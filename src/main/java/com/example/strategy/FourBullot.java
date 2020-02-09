package com.example.strategy;

import com.example.*;
import com.example.factory.BaseFactory;

public class FourBullot implements StrategyFactory {
    private static volatile FourBullot fourBullot = null;
   private FourBullot(){};
    public static FourBullot getFourBullot(){
        if(fourBullot == null){
            synchronized (FourBullot.class){
                if(fourBullot == null){
                    fourBullot = new FourBullot();
                }
            }
        }
        return fourBullot;
    }
    @Override
    public void fire(Tank tank, BaseFactory baseFactory) {
        int xk =tank.getX()+ Tank.T_WIDTH /2 - Bullot.B_WIDTH/2;
        int yk =tank.getY() + Tank.T_THINTH /2 - Bullot.B_THINTH/2;
        Dir[] values = Dir.values();
        for(int i=0;i< values.length;i++){
            baseFactory.getWeaponBullet(xk,yk,values[i],tank.getTankFrame(),Group.GOOD.getCode());
        }
        //todo 声音
        new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    public static void main(String[] args) {
        for(int i=0;i < 20;i++){
            new Thread(()->{
                System.out.println(getFourBullot().hashCode());;
            }).start();
        }

    }
}
