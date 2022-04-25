package emt.lab.labexercise.web.rest;

import emt.lab.labexercise.model.Book;
import emt.lab.labexercise.model.dto.BookDto;
import emt.lab.labexercise.service.AuthorService;
import emt.lab.labexercise.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookRestController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public List<Book> getAll() {
        return this.bookService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = this.bookService.findById(id);
        if (book != null) return ResponseEntity.ok().body(book);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Book> addBook(@RequestBody BookDto dtoBook) {
        Book book = new Book();
        book.setName(dtoBook.getName());
        book.setAuthor(this.authorService.findById(dtoBook.getAuthorId()));
        book.setAvailableCopies(dtoBook.getAvailableCopies());
        book.setCategory(dtoBook.getCategory());
        book.setIsInGoodCondition(dtoBook.getIsInGoodCondition());

        this.bookService.save(book);
        return ResponseEntity.ok(book);
    }

    @PostMapping(path = "/edit/{id}")
    public ResponseEntity<Book> saveBook(@PathVariable Long id, @RequestBody BookDto bookDto) {

        Book book = this.bookService.edit(id, bookDto);

        return book == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(book);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Book> deleteBook (@PathVariable Long id) {
        this.bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
