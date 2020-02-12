package com.collit;

import com.example.*;

import java.awt.*;

public class BullitAndWallCollison implements Collison {
    @Override
    public Boolean collison(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullot && o2 instanceof Wall){
            Bullot bullot = (Bullot)o1;
            Wall wall = (Wall)o2;
            //todo 怎么让这个正方形只new 一次
            Rectangle wallR = wall.getBulltRectange();//new Rectangle(x,y,B_WIDTH,B_THINTH);
            Rectangle bullotR = bullot.getBulltRectange();//new Rectangle(enemy.getX(),enemy.getY(),TankEnemy.E_WIDTH,TankEnemy.E_THINTH);
            if(wallR.intersects(bullotR)){
                new Explode(bullot.getX(),bullot.getY());
                bullot.die();
                return false;
            }
            return true;
        }else if(o2 instanceof Bullot  && o1 instanceof Wall){
           return collison(o2,o1);
        }else {
            return true;
        }
    }
}
