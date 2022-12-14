package by.tms.hackathonserver.repository;

import by.tms.hackathonserver.model.Product;
import by.tms.hackathonserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    Optional<User> findByEmailAndPassword(String username, String password);
}
