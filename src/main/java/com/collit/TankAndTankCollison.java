package com.collit;

import com.example.*;

import java.awt.*;

/**
 * 坦克和坦克碰撞
 */
public class TankAndTankCollison implements Collison {
    @Override
    public Boolean collison(GameObject o1, GameObject o2) {
        if(o1 instanceof TankEnemy && o2 instanceof TankEnemy){
            TankEnemy enemy = (TankEnemy)o1;
            TankEnemy enemy2 = (TankEnemy)o2;
            if(!enemy.getGroup().equals(enemy2.getGroup())){
                return false;
            }
            //todo 怎么让这个正方形只new 一次
            Rectangle re1 = enemy2.getEmenTankR();
            Rectangle re2 = enemy.getEmenTankR();
            if(re1.intersects(re2)){
                changeDirection(enemy);
                changeDirection(enemy2);
            }
            return false;
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
