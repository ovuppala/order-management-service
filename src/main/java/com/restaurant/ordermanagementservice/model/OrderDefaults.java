package com.restaurant.ordermanagementservice.model;

public class OrderDefaults{
    public enum OrderStatus {
        PLACED(1),
        ON_THE_FLAME(2),
        FEASTING(3);

        int lifeCycleOrder;

        OrderStatus(int order){
            this.lifeCycleOrder = order;
        }

        public OrderStatus next(int order){
            switch(order){
                case 1:
                    return ON_THE_FLAME;
                case 2:
                default:
                    return FEASTING;
            }
        }
        public int getLifeCycleOrder(){
            return this.lifeCycleOrder;
        }

    };
    public enum OrderType{TAKE_OUT, DINE_IN};
}