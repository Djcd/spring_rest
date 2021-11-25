package wildcodeschool.spring.rest.service.interfaces;

import wildcodeschool.spring.rest.dto.BookData;

import java.util.List;

public interface BookService {
    BookData saveBook(BookData bookData);
    boolean deleteBook(final Long bookId);
    BookData updateBook(BookData bookData);
    List<BookData> getAllBooks();
    BookData getBookById(final Long bookId);
    List<BookData> findBooks(String search);
}
