package com.example;

import lombok.Data;

import java.awt.*;
import java.util.concurrent.ThreadPoolExecutor;

@Data
public class Explode extends GameObject{

    private int x,y;
    private Boolean live =true;
    private int count=0;
    public static final int T_WIDTH = ResourceMges.EXPODELIST[0].getWidth();
    public static final int T_THINTH = ResourceMges.EXPODELIST[0].getHeight();

    public Explode(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        GameModel.getInstanct().addObject(this);
    }
    @Override
    public void paint(Graphics g) {

        //todo 展现图片方向
            int xk =x + TankEnemy.E_WIDTH/2 - T_WIDTH/2;
            int yk =y + TankEnemy.E_THINTH /2 - T_WIDTH/2;
          g.drawImage(ResourceMges.EXPODELIST[count++],xk,yk,null);
          //
        if(count >=ResourceMges.EXPODELIST.length){
            GameModel.getInstanct().removeObject(this);
        }
        //todo 声音
        new Thread(()->{
            new Audio("audio/explode.wav").play();
        }).start();
    }

    @Override
    public int getWidth() {
        return T_WIDTH;
    }

    @Override
    public int getThinth() {
        return T_THINTH;
    }

}
