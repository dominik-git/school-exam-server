package sk.bavaria.bavaria.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sk.bavaria.bavaria.model.Photo;
import sk.bavaria.bavaria.repository.GalleryRepository;

import java.util.List;

@Service
public class GalleryServiceImpl {

    @Autowired
    private GalleryRepository galleryRepository;


    public List<Photo> getAllPhotos() {
        return galleryRepository.findAll();
    }

    public void savePhoto(MultipartFile photo) throws Exception{
        Photo carPhoto = new Photo();
       carPhoto.setData(photo.getBytes());
        galleryRepository.save(carPhoto);
    }

    public void deletePhotoByID(long id) {
        galleryRepository.delete(id);
    }
}
