package com.restaurant.ordermanagementservice.dto;

import com.restaurant.ordermanagementservice.model.CustomerInformation;
import com.restaurant.ordermanagementservice.model.Item;
import lombok.*;

import java.util.List;

@Data
@Builder
public class OrderDto {
    @NonNull
    private String orderType;
    private CustomerInformation customerInformation;
    @NonNull
    private List<Item> items;
}
