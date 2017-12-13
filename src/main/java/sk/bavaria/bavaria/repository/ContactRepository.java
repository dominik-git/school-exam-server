package sk.bavaria.bavaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.bavaria.bavaria.model.ContactInfo;
import sk.bavaria.bavaria.model.Review;

import java.util.List;

public interface ContactRepository extends JpaRepository<ContactInfo,Long> {

}
