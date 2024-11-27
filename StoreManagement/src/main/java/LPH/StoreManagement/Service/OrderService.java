package LPH.StoreManagement.Service;

import java.util.List;

import LPH.StoreManagement.Model.Order;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<String> createOrder(Order order);
    ResponseEntity<String>  updateOrder(int id,Order order);
    ResponseEntity<String>  deleteOrder(int id);
    Order  getOrderById(int id);
    List<Order>  getAllOrder();
    
} 

    



    
   
      

