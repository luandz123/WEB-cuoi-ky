package LPH.StoreManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import LPH.StoreManagement.Model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    OrderItem findOrderItemById(int id);

    
} 
