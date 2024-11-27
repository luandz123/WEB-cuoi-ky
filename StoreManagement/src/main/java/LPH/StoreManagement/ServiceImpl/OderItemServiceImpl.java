package LPH.StoreManagement.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import LPH.StoreManagement.Model.OrderItem;
import LPH.StoreManagement.Repository.OrderItemRepository;
import LPH.StoreManagement.Service.OrderItemService;
import LPH.StoreManagement.utils.Util;

@Service
public class OderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public ResponseEntity<String> createOrderItem(OrderItem orderItem){
        orderItemRepository.save(orderItem);
        return Util.getResponseEntity("success create order", HttpStatus.OK);
    }
    @Override
    public ResponseEntity<String>  updateOrderItem(int id,OrderItem orderItemed){
        try {
            OrderItem orderItem = orderItemRepository.findOrderItemById(id);
            orderItem.setOrder(orderItem.getOrder());
            orderItem.setProduct(orderItem.getProduct());
            orderItem.setQuantity(orderItem.getQuantity());
            orderItemRepository.save(orderItem);
            return Util.getResponseEntity("success update", HttpStatus.OK);
        }catch (Exception e) {
            return Util.getResponseEntity("orderItem not found", HttpStatus.NOT_FOUND);
        }

    }
    @Override
    public ResponseEntity<String>  deleteOrderItem(int id){
        try {
            OrderItem orderItem = orderItemRepository.findOrderItemById(id);
            orderItemRepository.delete(orderItem);
            return Util.getResponseEntity("success delete", HttpStatus.OK);
        }catch (Exception e) {
            return Util.getResponseEntity("orderItem not found", HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public OrderItem  getOrderItemById(int id){
        OrderItem orderItem = orderItemRepository.findOrderItemById(id);
        if (orderItem == null) {
            throw new RuntimeException("orderItem not found");
        }
        return orderItem;
    }
    @Override
    public List<OrderItem>  getAllOrderItem(){
        return orderItemRepository.findAll();
    }
}
