package com.example;

import com.example.factory.BaseBullet;
import lombok.Data;

import java.awt.*;

@Data
public class RectBullot extends BaseBullet {

    private int x,y;

    private Dir dir=Dir.DOWN;

    private Boolean live=true;

    private TankFrame tk=null;

    private String group ;
    private static final int NUM = 40;
    //定义子弹的正方形位置
    Rectangle bulltR= new Rectangle();

    public static final int B_WIDTH = ResourceMges.bulltU.getWidth();
    public static final int B_THINTH = ResourceMges.bulltU.getHeight();
    public RectBullot(int x, int y, Dir dir, TankFrame tk, String group) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tk = tk;
        this.group = group;
        tk.listBulls.add(this);
    }
    @Override
    public void paint(Graphics g) {
        if(!live){
             tk.listBulls.remove(this);
        }
        Color color = g.getColor();
        g.setColor(Color.BLUE);
        switch (dir) {
            case LIFT:
                g.fillRect(x, y, 15, 3);
                break;
            case RIGHT:
                g.fillRect(x, y, 15, 3);
                break;
            case UP:
                g.fillRect(x, y, 3, 15);
                break;
            case DOWN:
                g.fillRect(x, y, 3, 15);
                break;
            default:
                break;
        }
        g.setColor(color);
       /* Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, THINTH);
        g.setColor(color);*/
        move();
    }

    private void move() {
        switch (dir) {
            case LIFT:
                x  -= NUM;
                break;
            case RIGHT:
                x += NUM;
                break;
            case UP:
                y -= NUM;
                break;
            case DOWN:
                y += NUM;
                break;
            default:
                break;
        }
        if(x<0||y<0||x > TankFrame.GAME_HEIGHT|| y>TankFrame.GAME_WIDTH){
            this.live = false;
        }
        //todo x y,有变化时从新赋值
        bulltR.setRect(x,y,B_WIDTH,B_THINTH);

    }
    @Override
    public  void collison(TankEnemy enemy){
        //todo 如果是自己的子弹和坦克就返回
        if(enemy.getGroup().equals(this.group)){
            return;
        }
        //todo 怎么让这个正方形只new 一次
        //Rectangle bulltR = new Rectangle(x,y,B_WIDTH,B_THINTH);
        Rectangle emenTankR = enemy.getEmenTankR();//new Rectangle(enemy.getX(),enemy.getY(),TankEnemy.E_WIDTH,TankEnemy.E_THINTH);
        if(bulltR.intersects(emenTankR)){
            //tk.explodeList.add(new Explode(enemy.getX(),enemy.getY(),this.tk));
            tk.explodeList.add(tk.baseFactory.getWeaponExplode(enemy.getX(),enemy.getY(),this.tk));
            this.die();
            enemy.die();
        }
    }
    public void die(){
        live=false;
    }
}
