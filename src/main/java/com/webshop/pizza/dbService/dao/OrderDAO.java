package com.webshop.pizza.dbService.dao;

import com.webshop.pizza.dbService.dataSets.Order;
import com.webshop.pizza.dbService.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderDAO {
    private final Executor executor;
    private final SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public OrderDAO(Connection connection){
        executor = new Executor(connection);
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists order(id int, client_name varchar(100), client_phone varchar(20), cost float, date datetime, primary key (id))");
    }

    public void insert(Order order) throws SQLException {
        executor.execUpdate(String.format("insert into order (client_name, client_phone, cost, date) values ('%s', '%s', %f, %s)",
                order.getClientName(), order.getClientPhone(), order.getCost(), sqlFormat.format(order.getDate())));
    }

    public Order get(int id) throws SQLException {
        return executor.execQuery("select * from order where id=" + id,result -> {
            result.next();
            return new Order(
                    result.getInt("id"),
                    result.getString("client_name"),
                    result.getString("client_phone"),
                    result.getFloat("cost"),
                    result.getTimestamp("date"));
        });
    }

    public Order[] getAll() throws SQLException {
        return executor.execQuery("select * from order", result -> {
            var list = new LinkedList<Order>();
            while (result.next())
            {
                list.add(new Order(result.getInt("id"),
                        result.getString("client_name"),
                        result.getString("client_phone"),
                        result.getFloat("cost"),
                        result.getTimestamp("date")));
            }

            return list.toArray(new Order[0]);
        });
    }

    public void update(Order order) throws SQLException {
        executor.execUpdate(String.format("update order set cost=%f, client_name=%s, client_phone=%s, date=%s where id=%d",
                order.getCost(), order.getClientName(), order.getClientPhone(), sqlFormat.format(order.getDate()), order.getId()));
    }

    public void delete(int id) throws SQLException {
        executor.execUpdate("delete from order where id=" + id);
    }
}
