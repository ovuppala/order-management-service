package com.restaurant.ordermanagementservice.service;

import com.restaurant.ordermanagementservice.dto.OrderDto;
import com.restaurant.ordermanagementservice.model.Order;
import com.restaurant.ordermanagementservice.model.OrderDefaults;
import com.restaurant.ordermanagementservice.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepo;

    public String placeOrder(OrderDto order){
        Order orderDocument = new Order();
        orderDocument.setItems(order.getItems());
        orderDocument.setCustomerDetails(order.getCustomerInformation());
        orderDocument.setOrderType(OrderDefaults.OrderType.valueOf(order.getOrderType()));
        orderRepo.insert(orderDocument);
        return "Order placed succesfully";
    }

    public void updateOrderStatusByCustomerInformation(String firstName){
        Optional.of(orderRepo.findOrderByCustomerDetailsFirstName(firstName))
                .ifPresent(order -> {
                    order.setOrderStatus(order.getOrderStatus().next(order.getOrderStatus().getLifeCycleOrder()));
                    orderRepo.save(order);
                });
    }


}
