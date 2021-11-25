package wildcodeschool.spring.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wildcodeschool.spring.rest.dto.BookData;
import wildcodeschool.spring.rest.service.BookServiceDefault;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Resource(name = "BookService")
    private BookServiceDefault bookService;

    @GetMapping
    public List<BookData> getJokes() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookData getBook(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookData saveBook(@RequestBody BookData book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/search/{searchTerm}")
    public List<BookData> search(@PathVariable String searchTerm){
        return bookService.findBooks(searchTerm);
    }

    @PutMapping
    public BookData updateBook(@RequestBody BookData book) {
        if(book.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
}
