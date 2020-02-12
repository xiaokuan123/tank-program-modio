package com.example;

import lombok.Data;

import java.awt.*;
@Data
public abstract class GameObject {
   public int x,y;
    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getThinth();

}
