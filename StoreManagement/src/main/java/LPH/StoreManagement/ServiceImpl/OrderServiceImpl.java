package LPH.StoreManagement.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import LPH.StoreManagement.Model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import LPH.StoreManagement.Repository.OrderRepository;
import LPH.StoreManagement.Service.OrderService;
import LPH.StoreManagement.utils.Util;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public ResponseEntity<String> createOrder(Order order){
        orderRepository.save(order);
        return Util.getResponseEntity("", HttpStatus.OK);

    }
    @Override
    public ResponseEntity<String>  updateOrder(int id,Order ordered){
        try {
            Order order = orderRepository.findOrderById(id);
            order.setCreatedAt(ordered.getCreatedAt());
            order.setStatus(ordered.getStatus());
            order.setTotalPrice(ordered.getTotalPrice());
            order.setUser(ordered.getUser());
            orderRepository.save(order);
            return Util.getResponseEntity("success update", HttpStatus.OK);
        }catch (Exception e) {
            return Util.getResponseEntity("oder not found", HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<String>  deleteOrder(int id){
        try {
            Order order = orderRepository.findOrderById(id);
            orderRepository.delete(order);
            return Util.getResponseEntity("success delete", HttpStatus.OK);
        }catch (Exception e) {
            return Util.getResponseEntity("order not found", HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public Order  getOrderById(int id){
        Order order = orderRepository.findOrderById(id);
        if (order == null) {
            throw new RuntimeException("order not found");
        }
        return order;
    }
    @Override
    public List<Order>  getAllOrder(){
        return orderRepository.findAll();
    }
}
