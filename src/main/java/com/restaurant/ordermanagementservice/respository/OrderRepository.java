package com.restaurant.ordermanagementservice.respository;

import com.restaurant.ordermanagementservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    @Query("{'customerDetails.firstName': ?0 }")
    Order findOrderByCustomerDetailsFirstName(String name);
}
