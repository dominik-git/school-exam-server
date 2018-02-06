package sk.bavaria.bavaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.bavaria.bavaria.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
