package wildcodeschool.spring.rest.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wildcodeschool.spring.rest.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
