package com.example;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
@Component
public class ResourceMges {
    private ResourceMges(){};

    public static BufferedImage tankU,tankD,tankL,tankR,bulltU,bulltD,bulltL,bulltR,ememyTankD;
    public static BufferedImage[] EXPODELIST=new BufferedImage[4];
    static {
        try {
            tankU = ImageIO.read(ResourceMges.class.getClassLoader().getResourceAsStream("images/tanku.png"));
            tankD = ImageUtl.rotateImage(tankU,180);//ImageIO.read(ResourceMges.class.getClassLoader().getResourceAsStream("images/tankd.png"));
            tankL = ImageUtl.rotateImage(tankU,-90);//ImageIO.read(ResourceMges.class.getClassLoader().getResourceAsStream("images/tankl.png"));
            tankR = ImageUtl.rotateImage(tankU,90);//ImageIO.read(ResourceMges.class.getClassLoader().getResourceAsStream("images/tankr.png"));

            bulltU = ImageIO.read(ResourceMges.class.getClassLoader().getResourceAsStream("images/bulltU.png"));
            bulltD = ImageUtl.rotateImage(bulltU,180);//ImageIO.read(ResourceMges.class.getClassLoader().getResourceAsStream("images/bulltD.png"));
            bulltL = ImageUtl.rotateImage(bulltU,-90);//ImageIO.read(ResourceMges.class.getClassLoader().getResourceAsStream("images/bulltL.png"));
            bulltR = ImageUtl.rotateImage(bulltU,90);//ImageIO.read(ResourceMges.class.getClassLoader().getResourceAsStream("images/bulltR.png"));

            //敌人坦克
            ememyTankD = ImageIO.read(ResourceMges.class.getClassLoader().getResourceAsStream("images/enemytD.png"));

            //炸弹
            for(int i=0;i<3;i++){
                EXPODELIST[i] =ImageIO.read(ResourceMges.class.getClassLoader().getResourceAsStream("explain/E"+(i+1)+".png"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 静态内部类
     * todo 1,主要是为了本类 使用外部一般不用所有放入内部，不为外部可见
     * todo 2,作为单例时有懒加载的功能，只有调用的时候才加载
     * todo 3,保证多线程安全是jvm 的功劳，因为一个类漏到内存里只有一个
     */
    private static class ResourceMgesHolder{
        private static final ResourceMges INSTANCE = new ResourceMges();
    }

    public static ResourceMges getInstance(){
        return ResourceMgesHolder.INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(getInstance().hashCode());;
            }).start();
        }

    }
}
