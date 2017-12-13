package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.bavaria.bavaria.model.CarPhoto;
import sk.bavaria.bavaria.serviceImpl.GalleryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/gallery")
@Api(value="/gallery", description="Basic crud over carPhoto entity.")
public class GalleryService {

    @Autowired
    private GalleryServiceImpl galleryService;

    @PostMapping
    public void create(@RequestParam MultipartFile photo) throws Exception{
        galleryService.savePhoto(photo);
    }

    @GetMapping
    public List<CarPhoto> getAll() {
        return galleryService.getAllPhotos();
    }

    @PostMapping("/{id}")
    public void deletePhoto(@RequestParam(required = true) int id){
        galleryService.deletePhotoByID(id);
    }

}
