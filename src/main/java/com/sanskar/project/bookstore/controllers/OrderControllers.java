package com.sanskar.project.bookstore.controllers;

import com.sanskar.project.bookstore.dto.OrdersDTO;
import com.sanskar.project.bookstore.entity.OrdersEntity;
import com.sanskar.project.bookstore.services.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderControllers {
    private final OrdersService ordersService;

    public OrderControllers(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public OrdersDTO addNewOrder(@RequestBody OrdersDTO ordersDTO){
        System.out.println(ordersDTO.toString());
        return ordersService.addNewOrder(ordersDTO);
    }

    @GetMapping
    public List<OrdersEntity> getAllOrders(){
        return ordersService.getAllOrders();
    }
}
