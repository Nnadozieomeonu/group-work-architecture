package com.groupjn.orderservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.groupjn.orderservice.common.Payment;
import com.groupjn.orderservice.common.TransactionRequest;
import com.groupjn.orderservice.common.TransactionResponse;
import com.groupjn.orderservice.entity.Order;
import com.groupjn.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse boolOrder(@RequestBody TransactionRequest transactionRequest) throws JsonProcessingException {

        return orderService.saveOrder(transactionRequest);

        //do a rest call to payment gateway and pass the order id
    }



}
