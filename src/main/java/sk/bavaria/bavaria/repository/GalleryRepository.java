package sk.bavaria.bavaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.bavaria.bavaria.model.Photo;


public interface GalleryRepository extends JpaRepository<Photo,Long> {
}
