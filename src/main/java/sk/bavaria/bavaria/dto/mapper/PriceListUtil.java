package sk.bavaria.bavaria.dto.mapper;


import sk.bavaria.bavaria.dto.ServiceItemDTO;

import sk.bavaria.bavaria.model.ServiceItem;

public class PriceListUtil {

    private PriceListUtil() {
    }

    public static void enrichPriceListFromPriceListDTO(ServiceItem priceListToUpdate, ServiceItemDTO priceListDTO){
        priceListToUpdate.setService(priceListDTO.getService());
        priceListToUpdate.setServiceImage(priceListDTO.getServiceImage());
        priceListToUpdate.setDescription(priceListDTO.getDescription());
        priceListToUpdate.setPrice(priceListDTO.getPrice());
    }
}
