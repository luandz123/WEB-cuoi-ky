package LPH.StoreManagement.Service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import LPH.StoreManagement.Model.OrderItem;

public interface OrderItemService {

    

    ResponseEntity<String> createOrderItem(OrderItem orderItem);
    ResponseEntity<String>  updateOrderItem(int id,OrderItem orderItem);
    ResponseEntity<String>  deleteOrderItem(int id);
    OrderItem  getOrderItemById(int id);
    List<OrderItem>  getAllOrderItem();
   
}

