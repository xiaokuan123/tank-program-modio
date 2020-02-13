package com.example;

import com.example.factory.*;
import com.example.observer.*;
import com.example.strategy.DefaultBullot;
import com.example.strategy.FourBullot;
import com.example.strategy.StrategyFactory;
import lombok.Data;
import org.apache.commons.io.filefilter.OrFileFilter;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.example.Dir.*;

public class TankFrame extends Frame {
    public static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;
    public  Tank tank ;

    List<BaseExplode> explodeList = new ArrayList<>();
    //todo 抽象工厂的应用
    // BaseFactory baseFactory = new RectFactory();//;
    //todo 默认抽象工厂的应用
    BaseFactory baseFactory = new BadFactory();

    List<TankEnemy> enemyList = new ArrayList<>();

    StrategyFactory factory;
    //todo 抽象工厂里的抽象类
    List<BaseBullet> listBulls = new ArrayList<>();

    public TankFrame() {
        tank = new Tank(500, 500, DOWN, this);
        MyKeyListen.getMylisten().setTank(tank);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setResizable(false);
        this.setTitle("tank warld");
        this.setVisible(true);
        this.addKeyListener(MyKeyListen.getMylisten());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color color = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, GAME_WIDTH, GAME_WIDTH);
        graphics.setColor(color);
        paint(graphics);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.BLUE);
        g.drawString("子弹的数量" + listBulls.size(), 10, 100);
        g.drawString("敌方坦克的数量" + enemyList.size(), 10, 80);
        g.drawString("爆炸的数量" + explodeList.size(), 10, 120);
        g.setColor(color);
        tank.paint(g);
        //todo 敌人的坦克
        ememyTank(g);
        for (int i = 0; i < listBulls.size(); i++) {
            listBulls.get(i).paint(g);
        }
        //todo 子弹和坦克碰撞
        for (int i = 0; i < enemyList.size(); i++) {
            for (int j = 0; j < listBulls.size(); j++) {
                listBulls.get(j).collison(enemyList.get(i));
            }
        }
        //todo 爆炸
        for (int i = 0; i < explodeList.size(); i++) {
            explodeList.get(i).paint(g);
        }

    }

    private void ememyTank(Graphics g) {
        for (int i = 0; i < enemyList.size(); i++) {
            enemyList.get(i).paint(g);
        }
       /* Random random = new Random();
            Color color = g.getColor();
            g.setColor(Color.RED);
            enemy.paint(g);
            g.setColor(color);*/
    }

   //public class MyKeyListen extends KeyAdapter { }
}
