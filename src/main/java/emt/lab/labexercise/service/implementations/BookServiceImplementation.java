package emt.lab.labexercise.service.implementations;

import emt.lab.labexercise.exceptions.AuthorNotFoundException;
import emt.lab.labexercise.exceptions.BookNotFoundException;
import emt.lab.labexercise.model.Author;
import emt.lab.labexercise.model.Book;
import emt.lab.labexercise.model.dto.BookDto;
import emt.lab.labexercise.repository.AuthorRepository;
import emt.lab.labexercise.repository.BookRepository;
import emt.lab.labexercise.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImplementation(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book save(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Book save(BookDto bookDto) {

        Book book = new Book();

        book.setName(bookDto.getName());
        book.setAuthor(this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException("Author with ID: "+bookDto.getAuthorId()+" not found")));
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setCategory(bookDto.getCategory());
        book.setIsInGoodCondition(bookDto.getIsInGoodCondition());

        this.bookRepository.save(book);

        return book;
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Book edit(Long id, BookDto bookDto) {

        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with ID: "+id+" was not found."));

        book.setName(bookDto.getName());
        book.setAuthor(this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException("Author with ID: "+bookDto.getAuthorId()+" not found")));
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setCategory(bookDto.getCategory());
        book.setIsInGoodCondition(bookDto.getIsInGoodCondition());

        this.bookRepository.save(book);

        return book;
    }

    @Override
    public List<Book> findAllByName(String name) {
        return this.bookRepository.findAllByName(name);
    }

    @Override
    public List<Book> findAllByAuthor(Author author) {
        return this.bookRepository.findAllByAuthor(author);
    }

    @Override
    public List<Book> findAllByAvailableCopies(Integer availableCopies) {
        return this.bookRepository.findAllByAvailableCopies(availableCopies);
    }

    @Override
    public List<Book> findAllByAvailableCopiesGreaterThanEqual(Integer availableCopies) {
        return this.bookRepository.findAllByAvailableCopiesGreaterThanEqual(availableCopies);
    }

    @Override
    public List<Book> findAllByIsInGoodCondition(Boolean isInGoodCondition) {
        return this.bookRepository.findAllByIsInGoodCondition(isInGoodCondition);
    }
}
