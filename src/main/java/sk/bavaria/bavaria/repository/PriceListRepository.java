package sk.bavaria.bavaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.bavaria.bavaria.model.PriceList;

public interface PriceListRepository  extends JpaRepository<PriceList,Long> {
}
