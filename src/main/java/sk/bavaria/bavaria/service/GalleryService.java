package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.bavaria.bavaria.model.CarPhoto;
import sk.bavaria.bavaria.repository.GalleryRepository;

import java.util.List;

/**
 * Created by dominik.kolesar on 11/15/2017.
 */
@RestController
@RequestMapping("/gallery")
@Api(value="/gallery", description="Basic crud over car entity.")
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @PostMapping
    public Long create(@RequestParam MultipartFile photo) throws Exception{
        CarPhoto carPhoto = new CarPhoto();
        carPhoto.setData(photo.getBytes());
        return galleryRepository.save(carPhoto).getId();
    }

    @GetMapping
    public List<CarPhoto> getAll() {
        return galleryRepository.findAll();
    }

}
