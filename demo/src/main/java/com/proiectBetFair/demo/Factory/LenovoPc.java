package com.proiectBetFair.demo.Factory;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Lenovo")
public class LenovoPc extends Laptop {
    @Override
    public String getRam() {
        return "4 RAM";
    }

    public LenovoPc() {
    	this.setManufacturer(Manufacturer.LENOVO);
    }

}
