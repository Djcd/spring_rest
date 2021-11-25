package wildcodeschool.spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wildcodeschool.spring.rest.dto.BookData;
import wildcodeschool.spring.rest.model.Book;
import wildcodeschool.spring.rest.service.interfaces.BookService;
import wildcodeschool.spring.rest.service.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("BookService")
public class BookServiceDefault implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public BookData saveBook(BookData bookData) {
        Book book = populateJokeEntity(bookData);
        return populateBookData(repository.save(book));
    }

    @Override
    public boolean deleteBook(Long bookId) {
        repository.deleteById(bookId);
        return true;
    }

    @Override
    public BookData updateBook(BookData bookData) {
        Book book = populateJokeEntity(bookData);
        return populateBookData(repository.save(book));
    }

    @Override
    public List<BookData> getAllBooks() {
        List<BookData> books;
        List<Book> BookList = repository.findAll();
        books = BookList.stream().map(this::populateBookData).collect(Collectors.toList());
        return books;
    }

    @Override
    public BookData getBookById(Long bookId) {
        Book book = repository.findById(bookId).orElse(null);
        if(book == null)
            return null;
        else
            return populateBookData(book);
    }

    @Override
    public List<BookData> findBooks(String searchTerm) {
        List<BookData> books;
        List<Book> BookList = repository.findAllByTitleContainingOrAuthorContainingOrDescriptionContaining(searchTerm, searchTerm, searchTerm);
        books = BookList.stream().map(this::populateBookData).collect(Collectors.toList());
        return books;
    }

    private BookData populateBookData(final Book book){
        return new BookData(book.getId(), book.getTitle(), book.getAuthor(), book.getDescription());
    }

    private Book populateJokeEntity(BookData bookData){
        return new Book(bookData.getId(), bookData.getTitle(), bookData.getAuthor(), bookData.getDescription());
    }
}
