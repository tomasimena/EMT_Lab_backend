package emt.lab.labexercise.repository;

import emt.lab.labexercise.model.Author;
import emt.lab.labexercise.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByName (String name);

    List<Book> findAllByAuthor (Author author);

    List<Book> findAllByAvailableCopies (Integer availableCopies);

    List<Book> findAllByAvailableCopiesGreaterThanEqual (Integer availableCopies);

    List<Book> findAllByIsInGoodCondition (Boolean isInGoodCondition);

}
