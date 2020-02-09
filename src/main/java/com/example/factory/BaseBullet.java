package com.example.factory;

import com.example.TankEnemy;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void paint(Graphics g);
    public abstract void collison(TankEnemy enemy);
}
