package sk.bavaria.bavaria.dto.mapper;

import sk.bavaria.bavaria.dto.OrderItemDTO;
import sk.bavaria.bavaria.model.OrderItem;
import sk.bavaria.bavaria.model.ServiceItem;

import java.util.ArrayList;
import java.util.List;

public class OrderItemUtil {

    public static List<OrderItemDTO> createOrderItemDTOsFromOrderItems(List<OrderItem> orderItems) {
        //todo mapping ostatnycgh hodnot
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setId(orderItem.getId());
            orderItemDTO.setCarBrand((orderItem.getCarBrand()));
            orderItemDTO.setCarModel(orderItem.getCarModel());
            orderItemDTO.setEmailAddress(orderItem.getEmailAddress());
            orderItemDTO.setName(orderItem.getName());
            orderItemDTO.setSurname(orderItem.getSurname());
            orderItemDTO.setPhoneNumber(orderItem.getPhoneNumber());
            orderItemDTO.setProblemDescription(orderItem.getProblemDescription());
            orderItemDTO.setStatus(orderItem.getStatus());
            orderItemDTO.setYearOfMade(orderItem.getYearOfMade());
            orderItemDTO.setTime(orderItem.getTime());
            List<String> serviceItemNames = new ArrayList<>();
            for (ServiceItem serviceItem : orderItem.getServiceItems()) {
                serviceItemNames.add(serviceItem.getService());
            }
            orderItemDTO.setServiceItemNames(serviceItemNames);
            orderItemDTOS.add(orderItemDTO);

        }
        return orderItemDTOS;

    }

}
