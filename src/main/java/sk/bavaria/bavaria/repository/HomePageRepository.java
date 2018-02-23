package sk.bavaria.bavaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.bavaria.bavaria.model.HomePage;
import sk.bavaria.bavaria.model.Photo;

public interface HomePageRepository extends JpaRepository<HomePage,Long>{
}
