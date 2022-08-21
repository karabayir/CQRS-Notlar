package com.tunahan.axongiris.coreapi.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private final String oderId;

    public CreateOrderCommand(String oderId) {
        this.oderId = oderId;
    }

    // Kotlin veya Lombok kullanmaz isek aşağıdaki şekilde manuel oluşturmamız gerekebilir.

    public String getOderId() {
        return oderId;
    }

    @Override
    public String toString() {
        return "CreateOrderCommand{" +
                "oderId='" + oderId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrderCommand that = (CreateOrderCommand) o;
        return Objects.equals(oderId, that.oderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oderId);
    }
}
