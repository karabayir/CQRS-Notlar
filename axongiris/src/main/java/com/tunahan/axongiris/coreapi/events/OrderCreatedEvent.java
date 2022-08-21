package com.tunahan.axongiris.coreapi.events;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class OrderCreatedEvent {

    @TargetAggregateIdentifier
    private final String oderId;

    private final boolean orderConfirmed;

    public OrderCreatedEvent(String oderId, boolean orderConfirmed) {
        this.oderId = oderId;
        this.orderConfirmed = orderConfirmed;
    }

    // Kotlin veya Lombok kullanmaz isek aşağıdaki şekilde manuel oluşturmamız gerekebilir.

    public String getOderId() {
        return oderId;
    }
    public boolean getOrderConfirmed(){return  orderConfirmed;}

    @Override
    public String toString() {
        return "OrderCreatedEvent{" +
                "oderId='" + oderId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderCreatedEvent that = (OrderCreatedEvent) o;
        return Objects.equals(oderId, that.oderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oderId);
    }
}
