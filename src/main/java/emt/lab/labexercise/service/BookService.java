package emt.lab.labexercise.service;

import emt.lab.labexercise.model.Author;
import emt.lab.labexercise.model.Book;
import emt.lab.labexercise.model.dto.BookDto;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById (Long id);

    Book save (Book book);

    Book save (BookDto bookDto);

    void deleteById (Long id);

    Book edit (Long id, BookDto bookDto);

    List<Book> findAllByName (String name);

    List<Book> findAllByAuthor (Author author);

    List<Book> findAllByAvailableCopies (Integer availableCopies);

    List<Book> findAllByAvailableCopiesGreaterThanEqual (Integer availableCopies);

    List<Book> findAllByIsInGoodCondition (Boolean isInGoodCondition);

}
