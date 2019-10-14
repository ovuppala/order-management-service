package com.restaurant.ordermanagementservice.controller;

import com.restaurant.ordermanagementservice.dto.OrderDto;
import com.restaurant.ordermanagementservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/create", consumes = "application/json")
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderRequest){
        LOGGER.info("Request details" + orderRequest.toString());
        return new ResponseEntity<>( orderService.placeOrder(orderRequest), HttpStatus.CREATED);
    }

    @PostMapping(path = "/updateOrderStatus/{firstName}")
    public ResponseEntity updateOrderStatusByFirstName(@PathVariable String firstName){
        LOGGER.info("Updating order status for customer with First Name" + firstName);
        orderService.updateOrderStatusByCustomerInformation(firstName);
        return new ResponseEntity(HttpStatus.OK);
    }


}
