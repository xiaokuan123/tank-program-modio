package com.example;

import com.collit.BullitAndTankCollison;
import com.collit.ControllCollison;
import com.collit.TankAndTankCollison;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.Dir.DOWN;

public class GameModel {
    private static final GameModel INSTANCE = new GameModel();
    static {
        //先加载对象再new   tank
        INSTANCE.init();
    }
    private GameModel() {};

    //自己的坦克
    private Tank tank;
    //爆炸
    //List<Explode> explodeList = new ArrayList<>();
    //地方坦克
    //List<TankEnemy> enemyList = new ArrayList<>();
    //子弹
    //List<Bullot> listBulls = new ArrayList<>();
    //todo
    List<GameObject> objects = new ArrayList<>();
    //BullitAndTankCollison bullitAndTankCollison = new BullitAndTankCollison();
    //TankAndTankCollison tankAndTankCollison = new TankAndTankCollison();
    //todo 责任链模式
    ControllCollison controllCollison = new ControllCollison();

    public void addObject(GameObject gameModel) {
        objects.add(gameModel);
    }

    public void removeObject(GameObject gameModel) {
        objects.remove(gameModel);
    }
    //初始化地方坦克

    public static GameModel getInstanct() {
        return INSTANCE;
    }

    private void init() {
        tank = new Tank(500, 500, DOWN);
        int enemyTankCount = Integer.parseInt(ConfitTank.getInfo("countTankEnemy").toString());
        for (int i = 0; i < enemyTankCount; i++) {
            //enemyList.add(new TankEnemy(50+i*100,150,Dir.DOWN,this,Group.BLUE.getCode()));
            new TankEnemy(50 + i * 100, 150, Dir.DOWN, Group.BLUE.getCode());

        }
        addObject(new Wall(100, 100, 30, 200));
        addObject(new Wall(600, 600, 30, 200));
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.BLUE);
        g.drawString("子弹的数量" + objects.size(), 10, 100);
        g.drawString("敌方坦克的数量" + objects.size(), 10, 80);
        g.drawString("爆炸的数量" + objects.size(), 10, 120);
        g.setColor(color);
        tank.paint(g);
        //todo 敌人的坦克
        //ememyTank(g);
        //todo 子弹的操作
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
        //todo 子弹和坦克碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                controllCollison.collison(o1, o2);
                //bullitAndTankCollison.collison(o1,o2);
                //tankAndTankCollison.collison(o1,o2);
                //listBulls.get(j).collison(enemyList.get(i));
            }
        }
        //todo 爆炸
       /* for (int i = 0; i < objects.size(); i++) {
            //explodeList.get(i).paint(g);
            objects.get(i).paint(g);
        }*/

    }

    private void ememyTank(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
    }

    public Tank getMyTank() {
        return tank;
    }
}
