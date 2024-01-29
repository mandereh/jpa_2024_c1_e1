package org.example.entities;/*
 *
 *Created by phron on 1/25/2024
 *
 */

import jakarta.persistence.*;
import org.example.entities.generators.UUIDGenerator;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GenericGenerator(name = "UUIDGenerator", type = UUIDGenerator.class)
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id")
    private String id;
    private String name;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
