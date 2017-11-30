package sk.bavaria.bavaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.bavaria.bavaria.model.CarPhoto;


public interface GalleryRepository extends JpaRepository<CarPhoto,Long> {
}
