package task.managementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.managementSystem.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername (String username);
}
