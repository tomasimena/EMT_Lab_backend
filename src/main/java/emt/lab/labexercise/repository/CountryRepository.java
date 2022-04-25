package emt.lab.labexercise.repository;

import emt.lab.labexercise.model.Author;
import emt.lab.labexercise.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByName (String name);

    List<Country> findAllByAuthorsContaining (Author author);

    List<Country> findAllByContinent (String continent);

}
