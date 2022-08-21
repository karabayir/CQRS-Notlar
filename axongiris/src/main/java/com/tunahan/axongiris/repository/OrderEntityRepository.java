package com.tunahan.axongiris.repository;

import com.tunahan.axongiris.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepository extends JpaRepository<OrderEntity,String> {
}
