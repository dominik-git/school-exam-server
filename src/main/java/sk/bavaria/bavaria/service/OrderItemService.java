package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.bavaria.bavaria.dto.OrderItemDTO;
import sk.bavaria.bavaria.model.OrderItem;
import sk.bavaria.bavaria.model.Status;
import sk.bavaria.bavaria.repository.OrderItemRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

import static sk.bavaria.bavaria.dto.mapper.OrderItemUtil.createOrderItemDTOsFromOrderItems;

@RestController
@RequestMapping("/order")
@Api(value = "/order", description = "dad")
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;


    @PostMapping(consumes = "application/json", produces = "application/json")
    public void saveNewOrder(@RequestBody OrderItem order) {
        order.setStatus(Status.NEW);
        orderItemRepository.save(order);
    }

    @PostMapping(value = "/approveOrder/{id}")
    public void approveOrder(@PathVariable(value = "id", required = true) Long id) {
        OrderItem order = orderItemRepository.findOne(id);
        if (order == null) {
            throw new RuntimeException("Order not found for id:" + id);
        }
        order.setStatus(Status.APPROVED);
        orderItemRepository.save(order);
    }


    @PostMapping(value = "/archiveOrder/{id}")
    public void archiveOrder(@PathVariable(value = "id", required = true) Long id) {
        OrderItem order = orderItemRepository.findOne(id);
        order.setStatus(Status.ARCHIVED);
        orderItemRepository.save(order);
    }

    @PostMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        OrderItem order = orderItemRepository.findOne(id);
        orderItemRepository.delete(order);
    }

    @GetMapping(value = "/getAllNewOrders")
    public List<OrderItemDTO> getAllNewOrders() {
        return createOrderItemDTOsFromOrderItems(orderItemRepository.findByStatus(Status.NEW));

    }

    @GetMapping(value = "/getAllApprovedOrder")
    public List<OrderItemDTO> getAllApprovedOrder() {
        return createOrderItemDTOsFromOrderItems(orderItemRepository.findByStatus(Status.APPROVED));

    }

    @GetMapping(value = "/getAllArchivedOrder")
    public List<OrderItemDTO> getAllArchivedOrder() {
        return createOrderItemDTOsFromOrderItems(orderItemRepository.findByStatus(Status.ARCHIVED));
    }
}

