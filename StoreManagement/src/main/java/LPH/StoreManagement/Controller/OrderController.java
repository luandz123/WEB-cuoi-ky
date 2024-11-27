package LPH.StoreManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LPH.StoreManagement.Model.Order;
import LPH.StoreManagement.Service.OrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("getAll")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable int orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @PostMapping("create")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable int orderId, @RequestBody Order order) {
        return orderService.updateOrder(orderId, order);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable int orderId) {
        return orderService.deleteOrder(orderId);
    }
}
