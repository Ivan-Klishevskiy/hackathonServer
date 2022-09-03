package by.tms.hackathonserver.repository;

import by.tms.hackathonserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<List<Product>>findAllByCreatorUsername(String creatorUsername);

    Optional<List<Product>>findAllByCategory(String category);

    Optional<Product> findById(long id);

    Optional<Product> findByTitle(String title);
}
