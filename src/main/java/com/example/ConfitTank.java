package com.example;

import java.io.IOException;
import java.util.Properties;

public class ConfitTank {
    private ConfitTank(){};
    static Properties p = new Properties();
    static {
        try {
            p.load(ConfitTank.class.getClassLoader().getResourceAsStream("config/tankConfig"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getInfo(String key){
        if(p==null){
            return "";
        }
        Object o = p.get(key);
        return String.valueOf(o);
    }

    public static void main(String[] args) {
        System.out.println(getInfo("countTankEnemy"));
    }
}
