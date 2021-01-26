package com.webshop.pizza.dbService;

import com.webshop.pizza.dbService.dao.OrderDAO;
import com.webshop.pizza.dbService.dataSets.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private final Connection connection;

    public DBService(){
        this.connection = getMySQLConnection();
        System.out.println("Соединение с СУБД выполнено");
    }

    private Connection getMySQLConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db_pizza_shop";
            String login ="root";
            String pass = "";

            return DriverManager.getConnection(url, login, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addOrder(Order order) throws SQLException {
        connection.setAutoCommit(false);
        OrderDAO orderDAO = new OrderDAO(connection);
        orderDAO.createTable();
        orderDAO.insert(order);
        connection.commit();
    }

    public Order[] getAllOrders() throws SQLException {
        OrderDAO orderDAO = new OrderDAO(connection);
        return orderDAO.getAll();
    }
}
