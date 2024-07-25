package com.haoran.pojo;

import lombok.Data;

@Data
public class Order {
    private Integer orderId;
    private String orderName;
    // 对一关系：一个订单对应一个客户。属性中包含对方对象。
    private Customer customer;

}
