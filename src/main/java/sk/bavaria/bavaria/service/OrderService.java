package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.bavaria.bavaria.model.Order;
import sk.bavaria.bavaria.repository.OrderRepository;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/order")
@Api(value = "/order", description = "dad")
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @PostMapping(consumes = "application/json", produces = "application/json")
    public void saveNewOrder(@RequestBody Order order) {
        orderRepository.save(order);
    }

    @PostMapping(value = "/approveOrder/{id}")
    public void approveOrder(@PathVariable(value = "id") Long id) {
        Order order = orderRepository.findOne(id);
        Objects.nonNull(order);
        order.setApproved(true);
        order.setNewOrder(false);
        orderRepository.save(order);
    }

    @PostMapping(value = "/unApproveOrder/{id}")
    public void unApproveOrder(@PathVariable(value = "id") Long id) {
        Order order = orderRepository.findOne(id);
        Objects.nonNull(order);
        order.setApproved(false);
        order.setNewOrder(true);
        orderRepository.save(order);
    }

    @PostMapping(value = "/archiveOrder/{id}")
    public void archiveOrder(@PathVariable(value = "id") Long id) {
        Order order = orderRepository.findOne(id);
        Objects.nonNull(order);
        order.setArchived(true);
        order.setApproved(false);
        orderRepository.save(order);
    }

    @PostMapping(value = "/unArchiveOrder/{id}")
    public void unArchiveOrder(@PathVariable(value = "id") Long id) {
        Order order = orderRepository.findOne(id);
        Objects.nonNull(order);
        order.setArchived(false);
        order.setApproved(true);
        orderRepository.save(order);
    }

    @PostMapping(value = "/deleteOrder/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        Order order = orderRepository.findOne(id);
        orderRepository.delete(order);
    }

    @GetMapping(value = "/getAllNewOrders")
    public List<Order> getAllNewOrders() {
        return orderRepository.findByNewOrder(true);
    }
    @GetMapping(value = "/getAllApprovedOrder")
    public List<Order> getAllApprovedOrder() {
        return orderRepository.findByApproved(true);
    }
    @GetMapping(value = "/getAllArchivedOrder")
    public List<Order> getAllArchivedOrder() {
        return orderRepository.findByArchived(true);
    }
}

