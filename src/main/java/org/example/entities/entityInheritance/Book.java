package org.example.entities.entityInheritance;/*
 *
 *Created by phron on 2/4/2024
 *
 */

import jakarta.persistence.Entity;

@Entity
public class Book extends Product{
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", id=" + id +
                "} " + super.toString();
    }
}
