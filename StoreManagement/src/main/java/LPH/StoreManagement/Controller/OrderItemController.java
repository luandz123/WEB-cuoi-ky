package LPH.StoreManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LPH.StoreManagement.Model.OrderItem;
import LPH.StoreManagement.Service.OrderItemService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin
@RequestMapping("/api/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;
 
    @GetMapping("/create")
    public ResponseEntity<String> createOrderItem(@RequestBody OrderItem orderItem){
        return orderItemService.createOrderItem(orderItem);
    }
    @PutMapping("/update")
    public ResponseEntity<String>  updateOrderItem(int id,OrderItem orderItem){
        return orderItemService.updateOrderItem(id, orderItem);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String>  deleteOrderItem(int id){
        return orderItemService.deleteOrderItem(id);

    }
    @GetMapping("/{id}")
    OrderItem  getOrderItemById(@PathVariable int id){
        return orderItemService.getOrderItemById(id);
    }
    @GetMapping("/getAll")
    public List<OrderItem>  getAllOrderItem(){
        return orderItemService.getAllOrderItem();
    }

    
}

