package com.tunahan.axongiris.querymodel;

import com.tunahan.axongiris.coreapi.events.OrderCreatedEvent;
import com.tunahan.axongiris.coreapi.queries.FindAllOrderQuery;
import com.tunahan.axongiris.model.OrderEntity;
import com.tunahan.axongiris.repository.OrderEntityRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ProcessingGroup("orders")
public class OrderEventHandler {

    private final OrderEntityRepository orderEntityRepository;

    public OrderEventHandler(OrderEntityRepository orderEntityRepository) {
        this.orderEntityRepository = orderEntityRepository;
    }

    @EventHandler
    public void on(OrderCreatedEvent event){
        orderEntityRepository.save(new OrderEntity(event.getOderId(),event.getOrderConfirmed()));
    }

    @QueryHandler
    public List<OrderEntity> on(FindAllOrderQuery query){
        return orderEntityRepository.findAll();
    }
}
