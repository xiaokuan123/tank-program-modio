package com.example.factory;

import com.example.*;

public class BadFactory extends BaseFactory {


    @Override
    public BaseTank getWeaponTank(int x, int y, Dir dir, TankFrame frame, String group) {
        return new TankEnemy(x,y,dir,frame,Group.BLUE.getCode());
    }

    @Override
    public BaseBullet getWeaponBullet(int x, int y, Dir dir, TankFrame frame, String group) {
        return new Bullot(x,y,dir,frame,group);
    }

    @Override
    public BaseExplode getWeaponExplode(int x, int y, TankFrame frame) {
        return new Explode(x,y,frame);
    }


}
