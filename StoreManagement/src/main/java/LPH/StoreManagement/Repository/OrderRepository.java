package LPH.StoreManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import LPH.StoreManagement.Model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findOrderById(int id);
}

