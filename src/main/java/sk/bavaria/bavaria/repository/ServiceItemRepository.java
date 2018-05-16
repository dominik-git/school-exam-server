package sk.bavaria.bavaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.bavaria.bavaria.model.ServiceItem;

public interface ServiceItemRepository extends JpaRepository<ServiceItem,Long> {
}
