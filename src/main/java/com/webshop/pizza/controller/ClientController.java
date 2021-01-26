package com.webshop.pizza.controller;

import com.webshop.pizza.dbService.dataSets.Order;
import com.webshop.pizza.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.Date;

@Controller
public class ClientController {

    OrderService orderService = new OrderService();

    @GetMapping
    public String main(@ModelAttribute("order")Order order){
        return "order";
    }

    @PostMapping
    public String order(@ModelAttribute("order")Order order){
        System.out.println(order.getClientName());
//        try {
//            if(orderService.findAllOrders() == null) {
//                System.out.println("bebe");
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return "done";
    }
}