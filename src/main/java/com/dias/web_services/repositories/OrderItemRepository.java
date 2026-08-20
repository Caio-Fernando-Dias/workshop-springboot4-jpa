package com.dias.web_services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dias.web_services.entities.OrderItem;
import com.dias.web_services.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
    
    

}
