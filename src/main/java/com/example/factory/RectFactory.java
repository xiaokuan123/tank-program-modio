package com.example.factory;

import com.example.*;

public class RectFactory extends BaseFactory {


    @Override
    public BaseTank getWeaponTank(int x, int y, Dir dir, TankFrame frame, String group) {
        return null;
    }

    @Override
    public BaseBullet getWeaponBullet(int x, int y, Dir dir, TankFrame frame, String group) {
        return new RectBullot(x,y,dir,frame,group);
    }

    @Override
    public BaseExplode getWeaponExplode(int x, int y, TankFrame frame) {
        return new RectExplode(x,y,frame);
    }


}
