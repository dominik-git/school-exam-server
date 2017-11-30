package sk.bavaria.bavaria.service;


import org.springframework.web.multipart.MultipartFile;
import sk.bavaria.bavaria.model.CarPhoto;
import java.util.List;


public interface GalleryService {
    List<CarPhoto> getAllPhotos();
    void savePhoto(MultipartFile carPhoto) throws Exception;
    void deletePhotoByID(long id);

}
