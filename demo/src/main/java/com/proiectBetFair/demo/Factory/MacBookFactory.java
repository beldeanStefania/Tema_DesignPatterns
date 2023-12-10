package com.proiectBetFair.demo.Factory;

public class MacBookFactory extends LaptopFactory{
    @Override
    public Laptop getComputer() {
        return new MacBookPc();
    }
}
