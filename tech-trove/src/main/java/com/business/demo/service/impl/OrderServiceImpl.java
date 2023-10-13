package com.business.demo.service.impl;

import com.business.demo.converter.OrderConverter;
import com.business.demo.domain.OrderDTO;
import com.business.demo.repository.OrderRepository;
import com.business.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        return OrderConverter.INSTANCE.toOrderDTO(orderRepository.save(OrderConverter.INSTANCE.toOrder(orderDTO)));
    }

    @Override
    public List<OrderDTO> getOrders() {
        return OrderConverter.INSTANCE.toOrderDTOList(orderRepository.findAll());
    }

    @Override
    public OrderDTO getOrder(String id) {
        return OrderConverter.INSTANCE.toOrderDTO(orderRepository.findById(id).orElse(null));
    }
}
