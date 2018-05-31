package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.bavaria.bavaria.dto.AboutItemDto;
import sk.bavaria.bavaria.dto.mapper.AboutItemUtil;
import sk.bavaria.bavaria.model.AboutItem;
import sk.bavaria.bavaria.repository.AboutItemRepository;

import java.util.List;

@RestController
@RequestMapping("/aboutItem")
@Api(value = "/aboutItem", description = "Basic crud over aboutItem entity.")
public class AboutItemService {

    @Autowired
    AboutItemRepository aboutItemRepository;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void saveAboutItem(@RequestBody AboutItem aboutItem) {
        aboutItemRepository.save(aboutItem);
    }

    @GetMapping
    public List<AboutItem> getAboutItems() {
        return aboutItemRepository.findAll();
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public void updateContactInfo(@RequestBody AboutItemDto aboutItemDto, @PathVariable(value = "id") Long id) {
        AboutItem aboutItemToUpdate = aboutItemRepository.findOne(id);
        AboutItemUtil.enrichAboutItemFromAboutItemDTO(aboutItemToUpdate, aboutItemDto);
        aboutItemRepository.save(aboutItemToUpdate);

    }
}
