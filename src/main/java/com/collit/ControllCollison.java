package com.collit;

import com.example.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 责任链模式--所有的碰撞都在链条里面完成，如  tk-tk  tk-bu
 * 就是像一个链条一样都一个一个的执行
 * ControllCollison 也继承父类，为了它可以和其他的链条拼接
 */
public class ControllCollison implements Collison {
    private List<Collison> list = new LinkedList<>();
    public ControllCollison(){
        list.add(new BullitAndTankCollison());
        list.add(new TankAndTankCollison());
        list.add(new BullitAndWallCollison());
        list.add(new TankAndWallCollison());
    }
    public  List<Collison> getCollison(){
        return list;
    }
    @Override
    public Boolean collison(GameObject o1,GameObject o2){
        Boolean b=false;
        for(int i=0;i < list.size();i++){
            //todo 1.如果是o1,o2是都是坦克就没必要再判断==子弹和坦克碰撞这一环，2.如果是o1,o2是子弹和坦克，就不用判断
             b = list.get(i).collison(o1,o2);
            if(!b){
                break;
            }
        }
        return b;
    }

}
