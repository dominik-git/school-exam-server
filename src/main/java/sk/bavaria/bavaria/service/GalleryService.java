package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.bavaria.bavaria.model.Photo;
import sk.bavaria.bavaria.repository.GalleryRepository;


import java.util.List;

@RestController
@RequestMapping("/gallery")
@Api(value="/gallery", description="Basic crud over carPhoto entity.")
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @PostMapping
    public void create(@RequestParam MultipartFile photo) throws Exception{
        Photo carPhoto = new Photo();
        carPhoto.setData(photo.getBytes());
        galleryRepository.save(carPhoto);
    }

    @GetMapping
    public List<Photo> getAll() {
        return galleryRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletePhoto(@PathVariable(value="id") Long id){
        galleryRepository.delete(id);
    }

}

