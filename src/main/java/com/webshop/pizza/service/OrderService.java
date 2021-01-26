package com.webshop.pizza.service;

import com.webshop.pizza.dbService.DBService;
import com.webshop.pizza.dbService.dataSets.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class OrderService {
    private static ArrayList<Order> orders = new ArrayList<Order>();
    private DBService dbService = new DBService();

    public OrderService(){}

    public boolean addNewOrder(){return false;}//нинаю шо делать с айдишниками, поэтому добавление пока что такое

    public Order[] findAllOrders() throws SQLException { return dbService.getAllOrders();}
}
