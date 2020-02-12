package com.example;

import lombok.Data;

import java.awt.*;
@Data
public class Wall extends GameObject{
    int z;
    int w;
    Rectangle bulltRectange= new Rectangle();
    public Wall(int x,int y,int z,int w){
        this.x =x;
        this.y = y;
        this.z = z;
        this.w =w;
        bulltRectange.setRect(x,y,z,w);
    }
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.PINK);
        g.fillRect(x,y,z,w);
        g.setColor(color);

    }

    @Override
    public int getWidth() {
        return z;
    }

    @Override
    public int getThinth() {
        return w;
    }
}
