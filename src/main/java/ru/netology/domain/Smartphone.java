package ru.netology.domain;

import lombok.Data;

@Data
public class Smartphone extends Product {
    private String producer;


    public Smartphone() {
    }


    public Smartphone(int id, String name, int price, String producer) {
        super();
        this.producer = producer;
    }
}
