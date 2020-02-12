package com.decorator;

import com.example.GameModel;
import com.example.GameObject;

import java.awt.*;

public class BullitDecorator extends GODecorator {

    public BullitDecorator(GameObject go) {
        //todo 指向父类目的是画出原来的
        super(go);
        GameModel.getInstanct().addObject(this);
    }

    @Override
    public void paint(Graphics g) {
        this.setX(go.getX());
        this.setY(go.getY());

        //todo 指向父类目的是画出原来的
        super.paint(g);
        //todo 画出新的装饰
        Color color = g.getColor();
        g.setColor(Color.BLUE);
        //todo  go对象调用的方法是父类的，但是有具体的子类实现了的话，实际就是调用具体哪个子类实现的如bullit
        g.fillRect(this.getX(),this.getY(),super.go.getWidth(),go.getThinth());
        g.setColor(color);
    }

    @Override
    public int getWidth() {
        return go.getWidth();
    }

    @Override
    public int getThinth() {
        return go.getThinth();
    }
}
