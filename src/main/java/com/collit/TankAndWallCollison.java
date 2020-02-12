package com.collit;

import com.example.Dir;
import com.example.GameObject;
import com.example.TankEnemy;
import com.example.Wall;

import java.awt.*;

/**
 * 坦克和坦克碰撞
 */
public class TankAndWallCollison implements Collison {
    @Override
    public Boolean collison(GameObject o1, GameObject o2) {
        if(o1 instanceof TankEnemy && o2 instanceof Wall){
            TankEnemy enemy = (TankEnemy)o1;
            Wall wall = (Wall)o2;
            //todo 怎么让这个正方形只new 一次
            Rectangle re1 = wall.getBulltRectange();
            Rectangle re2 = enemy.getEmenTankR();
            if(re1.intersects(re2)){
                changeDirection(enemy);
            }
            return true;
        }else {
            return true;
        }
    }

    private void changeDirection(TankEnemy enemy) {
        if(enemy.getDir().equals(Dir.UP)){
            enemy.setDir(Dir.DOWN);
        }else if(enemy.getDir().equals(Dir.DOWN)){
            enemy.setDir(Dir.UP);
        }else if(enemy.getDir().equals(Dir.LIFT)){
            enemy.setDir(Dir.RIGHT);
        }else if(enemy.getDir().equals(Dir.RIGHT)){
            enemy.setDir(Dir.LIFT);
        }
    }
}
