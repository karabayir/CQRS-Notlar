package com.tunahan.axongiris;

import com.tunahan.axongiris.coreapi.commands.CreateOrderCommand;
import com.tunahan.axongiris.coreapi.queries.FindAllOrderQuery;
import com.tunahan.axongiris.model.OrderEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/v1/api/order")
public class OrderController {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public OrderController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/create")
    public String createOrder(){
        String orderId= UUID.randomUUID().toString();
        commandGateway.send(new CreateOrderCommand(orderId));
        return  orderId;
    }

    @GetMapping()
    public CompletableFuture<List<OrderEntity>> getAllOrders(){
        return queryGateway.query(new FindAllOrderQuery(), ResponseTypes.multipleInstancesOf(OrderEntity.class));
    }
}
