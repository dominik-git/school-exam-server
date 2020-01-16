package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.bavaria.bavaria.model.AboutItem;
import sk.bavaria.bavaria.repository.AboutItemRepository;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/aboutItem")
@Api(value = "/aboutItem", description = "Basic crud over aboutItem entity.")
public class AboutItemService {

    @Autowired
    AboutItemRepository aboutItemRepository;

    @PostMapping
    public void saveAboutItem(@RequestParam MultipartFile photo, @RequestParam String description, @RequestParam String title, @RequestParam String secondTitle ) throws IOException {
        AboutItem aboutItem = new AboutItem();
        aboutItem.setTitle(title);
        aboutItem.setSecondTitle(secondTitle);
        aboutItem.setPhotoData(photo.getBytes());
        aboutItem.setDescription(description);

        aboutItemRepository.save(aboutItem);
    }

    @GetMapping
    public List<AboutItem> getAboutItems() {
        return aboutItemRepository.findAll();
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public void deletePhoto(@PathVariable(value="id") Long id) throws Exception {
        aboutItemRepository.delete(id);
    }


}
