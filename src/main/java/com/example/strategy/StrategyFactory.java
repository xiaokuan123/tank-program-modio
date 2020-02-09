package com.example.strategy;

import com.example.Tank;
import com.example.TankFrame;
import com.example.factory.BaseFactory;

public interface StrategyFactory {
    void fire(Tank tank, BaseFactory baseFactory);
}
