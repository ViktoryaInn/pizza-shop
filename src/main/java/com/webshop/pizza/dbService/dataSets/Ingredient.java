package com.webshop.pizza.dbService.dataSets;

public class Ingredient {
    private final int id;
    private final String name;
    private final float price;

    public Ingredient(int id, String name, float price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return name + " " + price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
