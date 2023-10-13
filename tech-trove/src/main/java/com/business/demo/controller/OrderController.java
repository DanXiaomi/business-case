package com.business.demo.controller;

import com.business.demo.constants.OrderURIConstants;
import com.business.demo.domain.OrderDTO;
import com.business.demo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Save a new order",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Successful operation"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @PostMapping(value = OrderURIConstants.ORDERS)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO save(@RequestBody @Valid OrderDTO orderDTO) {
        return orderService.save(orderDTO);
    }

    @Operation(summary = "Get all orders",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping(value = OrderURIConstants.ORDERS)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getOrders() {
        return orderService.getOrders();
    }

    @Operation(summary = "Get order by Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping(value = OrderURIConstants.ORDERS_ID)
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO getOrder(@PathVariable String id) {
        return orderService.getOrder(id);
    }
}
