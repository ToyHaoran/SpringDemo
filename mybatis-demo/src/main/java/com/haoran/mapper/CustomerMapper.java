package com.haoran.mapper;

import com.haoran.pojo.Customer;

import java.util.List;

public interface CustomerMapper {

    // 查询客户和客户关联的订单信息！
    List<Customer> queryCustomerWithOrderList(Integer customerId);

}
