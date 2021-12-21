package ru.netology.domain;

import lombok.Data;

import java.util.Objects;

@Data
public class Smartphone extends Product {
    private String producer;


    public Smartphone() {
    }


    public Smartphone(int id, String name, int price, String producer) {
        super();
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
}
