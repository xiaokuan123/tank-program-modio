package com.collit;

import com.example.*;

import java.awt.*;

public class BullitAndTankCollison implements Collison {
    @Override
    public Boolean collison(GameObject o1, GameObject o2) {
        if(o1 instanceof TankEnemy && o2 instanceof Bullot){
           // ((Bullot) o2).collison((TankEnemy)o1);
            TankEnemy enemy = (TankEnemy)o1;
            Bullot bullot = (Bullot)o2;
            if(enemy.getGroup().equals(bullot.getGroup())){
                return true;
            }
            //todo 怎么让这个正方形只new 一次
            Rectangle bulltR = bullot.getBulltRectange();//new Rectangle(x,y,B_WIDTH,B_THINTH);
            Rectangle emenTankR = enemy.getEmenTankR();//new Rectangle(enemy.getX(),enemy.getY(),TankEnemy.E_WIDTH,TankEnemy.E_THINTH);
            if(bulltR.intersects(emenTankR)){
                //gameModel.addObject(new Explode(enemy.getX(),enemy.getY(),this.gameModel));
                //通过构造方法添加
                new Explode(enemy.getX(),enemy.getY());
                bullot.die();
                enemy.die();
                return false;
            }else {
                return true;
            }

        }else if(o2 instanceof TankEnemy && o1 instanceof Bullot){
           return collison(o2,o1);
        }else {
            return true;
        }
    }
}
