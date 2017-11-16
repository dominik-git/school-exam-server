package sk.bavaria.bavaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.bavaria.bavaria.model.CarPhoto;

/**
 * Created by dominik.kolesar on 11/15/2017.
 */
public interface GalleryRepository extends JpaRepository<CarPhoto,Long> {
}
