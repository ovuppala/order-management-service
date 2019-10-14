package com.restaurant.ordermanagementservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private OrderDefaults.OrderType orderType;
    private OrderDefaults.OrderStatus orderStatus = OrderDefaults.OrderStatus.PLACED;
    private CustomerInformation customerDetails;
    private List<Item> items = new ArrayList<>();
}
