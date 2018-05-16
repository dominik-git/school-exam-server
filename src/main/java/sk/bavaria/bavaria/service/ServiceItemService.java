package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.bavaria.bavaria.dto.ServiceItemDTO;
import sk.bavaria.bavaria.dto.mapper.PriceListUtil;
import sk.bavaria.bavaria.model.ServiceItem;
import sk.bavaria.bavaria.repository.ServiceItemRepository;

import java.util.List;

@RestController
@RequestMapping("/pricelist")
@Api(value="/pricelist", description="Basic crud over pricelist entity.")
public class ServiceItemService {

    @Autowired
    ServiceItemRepository serviceItemRepository;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void savePriceListItem(@RequestBody ServiceItem priceList) {
        serviceItemRepository.save(priceList);
    }

    @GetMapping
    public List<ServiceItem> getPriceListItems() {
        return serviceItemRepository.findAll();
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public void updateContactInfo(@RequestBody ServiceItemDTO priceListDTO, @PathVariable(value = "id") Long id) {
        ServiceItem priceListToUpdate = serviceItemRepository.findOne(id);
       PriceListUtil.enrichPriceListFromPriceListDTO(priceListToUpdate, priceListDTO);
        serviceItemRepository.save(priceListToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable(value="id") Long id){
        serviceItemRepository.delete(id);
    }
}
