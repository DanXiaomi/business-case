package com.business.demo.service;

import com.business.demo.domain.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO save(OrderDTO orderDTO);

    List<OrderDTO> getOrders();

    OrderDTO getOrder(String id);
}
