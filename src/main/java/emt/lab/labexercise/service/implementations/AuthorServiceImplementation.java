package emt.lab.labexercise.service.implementations;

import emt.lab.labexercise.model.Author;
import emt.lab.labexercise.model.Book;
import emt.lab.labexercise.model.Country;
import emt.lab.labexercise.repository.AuthorRepository;
import emt.lab.labexercise.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public Author save(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public List<Author> findAllByName(String name) {
        return this.authorRepository.findAllByName(name);
    }

    @Override
    public List<Author> findAllBySurname(String surname) {
        return this.authorRepository.findAllBySurname(surname);
    }

    @Override
    public List<Author> findAllByBooksContaining(Book book) {
        return this.authorRepository.findAllByBooksContaining(book);
    }

    @Override
    public List<Author> findAllByCountry(Country country) {
        return this.authorRepository.findAllByCountry(country);
    }
}
