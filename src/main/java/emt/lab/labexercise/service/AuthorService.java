package emt.lab.labexercise.service;

import emt.lab.labexercise.model.Author;
import emt.lab.labexercise.model.Book;
import emt.lab.labexercise.model.Country;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author findById (Long id);

    void deleteById (Long id);

    Author save (Author author);

    List<Author> findAllByName (String name);

    List<Author> findAllBySurname (String surname);

    List<Author> findAllByBooksContaining (Book book);

    List<Author> findAllByCountry (Country country);

}
