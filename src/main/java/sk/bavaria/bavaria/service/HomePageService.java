package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.bavaria.bavaria.dto.ContactInfoDTO;
import sk.bavaria.bavaria.dto.PhotoUpdateDto;
import sk.bavaria.bavaria.dto.mapper.ContactInfoUtil;
import sk.bavaria.bavaria.model.Car;
import sk.bavaria.bavaria.model.ContactInfo;
import sk.bavaria.bavaria.model.HomePage;
import sk.bavaria.bavaria.model.Photo;
import sk.bavaria.bavaria.repository.HomePageRepository;
import sk.bavaria.bavaria.repository.PhotoRepository;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/home")
@Api(value = "/home", description = "Create, Update photos in slider")

public class HomePageService {
    @Autowired
    private PhotoRepository photoRepository;

    @PostMapping
    public void create(@RequestParam(required = true) MultipartFile photo) throws Exception {
//        for (MultipartFile photoToSave : photos) {
            Photo sliderPhoto = new Photo();
            sliderPhoto.setData(photo.getBytes());
            photoRepository.save(sliderPhoto);
//        }
    }

    @GetMapping
    public List<Photo> getAll() {
        return photoRepository.findAllByOrderByOrderingAsc();
    }

//    @PostMapping(value = "/updateInfo/{id}", consumes = "application/json", produces = "application/json")
//    public void updateHomePageSlider(@RequestBody HomePage HomePageSliderPhotos, @PathVariable(value = "id") Long id) {
//        HomePage homePageSlider = homePageRepository.findOne(id);
//        homePageSlider.setPhotos(HomePageSliderPhotos.getPhotos());
//        homePageRepository.save(homePageSlider);
//    }

    @PostMapping(value = "/updatePhotos")
    public void updatePhotoOrdering(@RequestBody List<PhotoUpdateDto> photoUpdateDtos) {
        for (PhotoUpdateDto photoUpdateDto : photoUpdateDtos) {
            Photo photo = photoRepository.findOne(photoUpdateDto.getId());
            photo.setOrdering(photoUpdateDto.getOredering());
            photoRepository.save(photo);
        }
    }

}

