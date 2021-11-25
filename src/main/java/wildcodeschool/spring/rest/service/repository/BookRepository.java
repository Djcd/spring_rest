package wildcodeschool.spring.rest.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wildcodeschool.spring.rest.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByTitleContainingOrAuthorContainingOrDescriptionContaining(String title, String author, String description);

}
