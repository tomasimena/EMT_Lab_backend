package emt.lab.labexercise.service.implementations;

import emt.lab.labexercise.model.Author;
import emt.lab.labexercise.model.Country;
import emt.lab.labexercise.repository.CountryRepository;
import emt.lab.labexercise.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImplementation implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImplementation(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country save(Country country) {
        return this.countryRepository.save(country);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }

    @Override
    public Country findByName(String name) {
        return this.countryRepository.findByName(name);
    }

    @Override
    public List<Country> findAllByAuthorsContaining(Author author) {
        return this.countryRepository.findAllByAuthorsContaining(author);
    }

    @Override
    public List<Country> findAllByContinent(String continent) {
        return this.countryRepository.findAllByContinent(continent);
    }
}
