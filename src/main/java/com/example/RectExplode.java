package com.example;

import com.example.factory.BaseExplode;
import lombok.Data;

import java.awt.*;

@Data
public class RectExplode extends BaseExplode {

    private int x,y;
    private Boolean live =true;
    private TankFrame tankFrame;
    private int count=0;
    public static final int T_WIDTH = ResourceMges.EXPODELIST[0].getWidth();
    public static final int T_THINTH = ResourceMges.EXPODELIST[0].getHeight();

    public RectExplode(int x, int y, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.tankFrame =tankFrame;
    }

    @Override
    public void paint(Graphics g) {

        //todo 展现图片方向
        Color color = g.getColor();
        g.setColor(Color.CYAN);
        g.fillOval(x, y, 10*count++, 10*count++);
        g.setColor(color);
          //todo 控制展现几次
        if(count >=5){
            tankFrame.explodeList.remove(this);
        }
        //todo 声音
        new Thread(()->{
            new Audio("audio/explode.wav").play();
        }).start();
    }

}
