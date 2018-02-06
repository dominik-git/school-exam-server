package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.bavaria.bavaria.dto.PriceListDTO;
import sk.bavaria.bavaria.dto.mapper.PriceListUtil;
import sk.bavaria.bavaria.model.PriceList;
import sk.bavaria.bavaria.repository.PriceListRepository;

import java.util.List;

@RestController
@RequestMapping("/pricelist")
@Api(value="/pricelist", description="Basic crud over pricelist entity.")
public class PriceListService {

    @Autowired
    PriceListRepository priceListRepository;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void savePriceListItem(@RequestBody PriceList priceList) {
        priceListRepository.save(priceList);
    }

    @GetMapping
    public List<PriceList> getPriceListItems() {
        return priceListRepository.findAll();
    }

    @PostMapping(value = "/updateItem/{id}", consumes = "application/json", produces = "application/json")
    public void updateContactInfo(@RequestBody PriceListDTO priceListDTO, @PathVariable(value = "id") Long id) {
        PriceList priceListToUpdate = priceListRepository.findOne(id);
       PriceListUtil.enrichPriceListFromPriceListDTO(priceListToUpdate, priceListDTO);
        priceListRepository.save(priceListToUpdate);
    }

    @PostMapping("/delete/{id}")
    public void deleteService(@PathVariable(value="id") Long id){
        priceListRepository.delete(id);
    }
}
