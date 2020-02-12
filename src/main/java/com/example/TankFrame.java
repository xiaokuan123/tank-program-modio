package com.example;

import com.collit.BullitAndTankCollison;
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
    GameModel gameModel = GameModel.getInstanct();
    //画出战场
    public TankFrame() {
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setResizable(false);
        this.setTitle("tank warld");
        this.setVisible(true);
        this.addKeyListener(new MyKeyListen());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //同时更新画面
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
        //todo 门面模式启用
        gameModel.paint(g);
    }

    class MyKeyListen extends KeyAdapter {
        Boolean VL = false;
        Boolean VR = false;
        Boolean VU = false;
        Boolean VD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    VL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    VR = true;
                    break;
                case KeyEvent.VK_UP:
                    VU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    VD = true;
                    break;
                default:
                    break;
            }
            ;
            setKeytank();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    VL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    VR = false;
                    break;
                case KeyEvent.VK_UP:
                    VU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    VD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    // VD = false;
                    gameModel.getMyTank().makerBullot();
                    break;
                default:
                    break;
            }
            ;
            setKeytank();
        }

        public void setKeytank() {
            if (!VL && !VR && !VU && !VD) {
                GameModel.getInstanct().getMyTank().setMoveing(false);
            } else {
                gameModel.getMyTank().setMoveing(true);
                if (VL) {
                    gameModel.getMyTank().setDir(LIFT);
                }
                ;
                if (VR) {
                    gameModel.getMyTank().setDir(RIGHT);
                }
                ;
                if (VU) {
                    gameModel.getMyTank().setDir(UP);
                }
                ;
                if (VD) {
                    gameModel.getMyTank().setDir(DOWN);
                }
            }


        }

    }
}
