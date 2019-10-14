package com.restaurant.ordermanagementservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private String itemName;
    private Integer quantity;
    private String additionalInstructions;
}
