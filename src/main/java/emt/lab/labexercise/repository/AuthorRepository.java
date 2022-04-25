package emt.lab.labexercise.repository;

import emt.lab.labexercise.model.Author;
import emt.lab.labexercise.model.Book;
import emt.lab.labexercise.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByName (String name);

    List<Author> findAllBySurname (String surname);

    List<Author> findAllByBooksContaining (Book book);

    List<Author> findAllByCountry (Country country);



}
