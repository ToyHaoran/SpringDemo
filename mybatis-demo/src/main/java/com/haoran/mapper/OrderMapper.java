package com.haoran.mapper;

import com.haoran.pojo.Order;

public interface OrderMapper {
    // 根据ID查询订单，以及订单关联的用户的信息！
    Order queryOrderWithCustomer(Integer orderId);
}
