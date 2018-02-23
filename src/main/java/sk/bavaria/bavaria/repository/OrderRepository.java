package sk.bavaria.bavaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.bavaria.bavaria.model.Order;
import sk.bavaria.bavaria.model.Review;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByApproved(boolean approved);
    List<Order> findByArchived(boolean archived);
    List<Order> findByNewOrder(boolean newOrder);

}
