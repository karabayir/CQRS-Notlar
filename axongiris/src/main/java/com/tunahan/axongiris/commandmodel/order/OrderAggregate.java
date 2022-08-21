package com.tunahan.axongiris.commandmodel.order;

import com.tunahan.axongiris.coreapi.commands.CreateOrderCommand;
import com.tunahan.axongiris.coreapi.events.OrderCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private boolean orderConfirmed;

    public OrderAggregate() {}


    @CommandHandler
    public OrderAggregate(CreateOrderCommand command){   // required for OrderAggregate's life cycle start
        AggregateLifecycle.apply(new OrderCreatedEvent(command.getOderId(), false));
    }

    @EventSourcingHandler  // life cycyle sonlandı . Axon veritabanına kaydedilmiş oldu.
    public void on(OrderCreatedEvent event){
        this.orderId= event.getOderId();
        this.orderConfirmed= event.getOrderConfirmed();
    }
}
