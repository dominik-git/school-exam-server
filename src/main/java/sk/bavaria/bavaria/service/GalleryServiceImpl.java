package sk.bavaria.bavaria.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sk.bavaria.bavaria.model.CarPhoto;
import sk.bavaria.bavaria.repository.GalleryRepository;

import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService{

    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public List<CarPhoto> getAllPhotos() {
        return galleryRepository.findAll();
    }

    @Override
    public void savePhoto(MultipartFile photo) throws Exception{
        CarPhoto carPhoto = new CarPhoto();
       carPhoto.setData(photo.getBytes());
        galleryRepository.save(carPhoto);
    }

    @Override
    public void deletePhotoByID(long id) {
        galleryRepository.delete(id);
    }
}
