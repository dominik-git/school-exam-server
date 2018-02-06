package sk.bavaria.bavaria.dto.mapper;


import sk.bavaria.bavaria.dto.PriceListDTO;

import sk.bavaria.bavaria.model.PriceList;

public class PriceListUtil {

    private PriceListUtil() {
    }

    public static void enrichPriceListFromPriceListDTO(PriceList priceListToUpdate, PriceListDTO priceListDTO){
        priceListToUpdate.setService(priceListDTO.getService());
        priceListToUpdate.setServiceImage(priceListDTO.getServiceImage());
        priceListToUpdate.setDescription(priceListDTO.getDescription());
        priceListToUpdate.setPrice(priceListDTO.getPrice());
    }
}
