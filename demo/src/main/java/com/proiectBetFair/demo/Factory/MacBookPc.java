package com.proiectBetFair.demo.Factory;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Apple")
public class MacBookPc extends Laptop {
    @Override
    public String getRam() {
        return "8 RAM";
    }

    public MacBookPc() {
    	this.setManufacturer(Manufacturer.APPLE);
    }
}
