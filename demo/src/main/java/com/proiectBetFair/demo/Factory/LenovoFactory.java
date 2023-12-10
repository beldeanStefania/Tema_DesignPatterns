package com.proiectBetFair.demo.Factory;

public class LenovoFactory extends LaptopFactory{

    @Override
    public Laptop getComputer() {
        return new LenovoPc();
    }
}
