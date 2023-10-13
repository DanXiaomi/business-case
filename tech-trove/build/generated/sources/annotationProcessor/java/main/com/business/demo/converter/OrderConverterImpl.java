package com.business.demo.converter;

import com.business.demo.domain.OrderDTO;
import com.business.demo.model.Order;
import com.business.demo.model.OrderItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-13T17:06:27-0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 1.8.0_321 (Oracle Corporation)"
)
public class OrderConverterImpl implements OrderConverter {

    @Override
    public Order toOrder(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.id( orderDTO.getId() );
        List<OrderItem> list = orderDTO.getItems();
        if ( list != null ) {
            order.items( new ArrayList<OrderItem>( list ) );
        }

        return order.build();
    }

    @Override
    public OrderDTO toOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO.OrderDTOBuilder orderDTO = OrderDTO.builder();

        orderDTO.id( order.getId() );
        List<OrderItem> list = order.getItems();
        if ( list != null ) {
            orderDTO.items( new ArrayList<OrderItem>( list ) );
        }

        return orderDTO.build();
    }

    @Override
    public List<OrderDTO> toOrderDTOList(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderDTO> list = new ArrayList<OrderDTO>( orders.size() );
        for ( Order order : orders ) {
            list.add( toOrderDTO( order ) );
        }

        return list;
    }
}
