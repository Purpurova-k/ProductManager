package ru.netology.domain;

import lombok.Data;

import java.util.Objects;

@Data
public class Smartphone extends Product {
    private String producer;


    public Smartphone() {
    }


    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(producer, that.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), producer);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "producer='" + producer + '\'' +
                '}';
    }


    @Override
    public boolean matches(String search) {
        if (getName().contains(search)) {
            return true;
        }
        if (getProducer().contains(search)) {
            return true;
        }
        return false;
    }
}

