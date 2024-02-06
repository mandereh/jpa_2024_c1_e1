package org.example.entities.entityInheritance;/*
 *
 *Created by phron on 2/4/2024
 *
 */

import jakarta.persistence.Entity;

@Entity
public class ElectronicDevice extends Product{

    private int voltage;

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "voltage=" + voltage +
                ", id=" + id +
                "} " + super.toString();
    }
}
