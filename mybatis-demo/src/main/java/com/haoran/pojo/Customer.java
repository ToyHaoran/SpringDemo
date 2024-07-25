package com.haoran.pojo;

import lombok.Data;

import java.util.List;

// 多表结果实体类设计小技巧：
// 只有真实发生多表查询时，才需要设计和修改实体类，否则不提前设计和修改实体类！
// 无论多少张表联查，实体类设计都是两两考虑：
// 在查询映射的时候，只需要关注本次查询相关的属性！例如：查询订单和对应的客户，就不要关注客户中的订单集合！
@Data
public class Customer {
    private Integer customerId;
    private String customerName;
    // 对多关系：一个客户有多个订单。属性中包含对方对象集合。
    private List<Order> orderList;
}