package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.bavaria.bavaria.dto.PhotoUpdateDto;
import sk.bavaria.bavaria.model.HomePage;
import sk.bavaria.bavaria.model.Photo;
import sk.bavaria.bavaria.repository.HomePageRepository;
import sk.bavaria.bavaria.repository.PhotoRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
@Api(value = "/home", description = "Create, Update photos in slider")

public class HomePageService {
    @Autowired
    private HomePageRepository homePageRepository;

    @PostMapping
    public void create(@ModelAttribute  List<MultipartFile> photoList) throws Exception {
        List<Photo> photos = new ArrayList<>();
        for (MultipartFile photoToSave : photoList) {
            Photo photo = new Photo();
            photo.setData(photoToSave.getBytes());
            photos.add(photo);
        }
        HomePage homePageGallery = new HomePage();
        homePageGallery.setPhotos(photos);
        homePageRepository.save(homePageGallery);
    }
    @DeleteMapping
    public void create(@RequestParam(required = true) Long id) throws Exception {
        homePageRepository.delete(id);
    }

    @GetMapping
    public List<HomePage> getAll() {
        return homePageRepository.findAll();
    }



//    @PutMapping(value = "/updatePhotos")
//    public void updatePhotoOrdering(@RequestBody List<PhotoUpdateDto> photoUpdateDtos) {
//        for (PhotoUpdateDto photoUpdateDto : photoUpdateDtos) {
//            Photo photo = photoRepository.findOne(photoUpdateDto.getId());
//            photo.setOrdering(photoUpdateDto.getOredering());
//            photoRepository.save(photo);
//        }
//    }

}

