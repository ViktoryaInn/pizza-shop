package com.webshop.pizza.dbService.dataSets;

public class IngredientsOfOrder {
    private int orderID;
    private int ingredientID;

    public IngredientsOfOrder(int orderID, int ingredientID){
        this.orderID = orderID;
        this.ingredientID = ingredientID;
    }

    public Integer getOrderID(){return orderID;}
    public Integer getIngredientID(){return ingredientID;}
}
