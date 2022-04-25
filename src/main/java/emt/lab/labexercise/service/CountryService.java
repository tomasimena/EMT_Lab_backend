package emt.lab.labexercise.service;

import emt.lab.labexercise.model.Author;
import emt.lab.labexercise.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();

    Country findById (Long id);

    Country save (Country country);

    void deleteById (Long id);

    Country findByName (String name);

    List<Country> findAllByAuthorsContaining (Author author);

    List<Country> findAllByContinent (String continent);

}
