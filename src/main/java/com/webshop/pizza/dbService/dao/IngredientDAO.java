package com.webshop.pizza.dbService.dao;

import com.webshop.pizza.dbService.dataSets.Ingredient;
import com.webshop.pizza.dbService.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

public class IngredientDAO {
    private final Executor executor;

    public IngredientDAO(Connection connection){
        executor = new Executor(connection);
    }

    public void insert(Ingredient ingredient) throws SQLException {
        executor.execUpdate(String.format("insert into ingredient (name, price, date) values ('%s', %f)",
                ingredient.getName(), ingredient.getPrice()));
    }

    public Ingredient get(int id) throws SQLException {
        return executor.execQuery("select * from ingredient where id=" + id,result -> {
            result.next();
            return new Ingredient(result.getInt("id"), result.getString("name"), result.getFloat("price"));
        });
    }

    public Ingredient[] getAll() throws SQLException {
        return executor.execQuery("select * from ingredient", result -> {
            var list = new LinkedList<Ingredient>();
            while (result.next())
            {
                list.add(new Ingredient(result.getInt("id"), result.getString("name"), result.getFloat("price")));
            }

            return list.toArray(new Ingredient[0]);
        });
    }

    public void update(Ingredient ingredient) throws SQLException {
        executor.execUpdate(String.format("update ingredient set price=%f, name=%s where id=%d",
                ingredient.getPrice(), ingredient.getName(), ingredient.getId()));
    }

    public void delete(int id) throws SQLException {
        executor.execUpdate("delete from ingredient where id=" + id);
    }
}
