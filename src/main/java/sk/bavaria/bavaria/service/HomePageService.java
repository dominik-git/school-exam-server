package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.bavaria.bavaria.model.Photo;
import sk.bavaria.bavaria.model.PhotoType;
import sk.bavaria.bavaria.repository.PhotoRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
@Api(value = "/home", description = "Create, Update photos in slider")

public class HomePageService {
    @Autowired
    private PhotoRepository photoRepository;

    @PostMapping
    public void create(@ModelAttribute List<MultipartFile> photoList) throws Exception {
        List<Photo> photos = new ArrayList<>();
        for (MultipartFile photoToSave : photoList) {
            Photo photo = new Photo();
            photo.setData(photoToSave.getBytes());
            photo.setType(PhotoType.HOMEPAGE);
            photos.add(photo);
        }
        photoRepository.save(photos);

    }


    @DeleteMapping
    public void create(@RequestParam(required = true) Long id) throws Exception {
        photoRepository.delete(id);
    }

    @GetMapping
    public List<Photo> getAll() {
        return photoRepository.findAllByType(PhotoType.HOMEPAGE);
    }


}

