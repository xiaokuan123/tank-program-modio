package com.example.factory;

import com.example.Dir;
import com.example.Group;
import com.example.TankFrame;

public abstract class BaseFactory {
    public abstract BaseTank getWeaponTank(int x, int y, Dir dir, TankFrame frame, String group);
    public abstract BaseBullet getWeaponBullet(int x, int y, Dir dir, TankFrame frame, String group);
    public abstract BaseExplode getWeaponExplode(int x, int y, TankFrame frame);
}
