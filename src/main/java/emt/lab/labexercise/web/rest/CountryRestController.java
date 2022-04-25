package emt.lab.labexercise.web.rest;

import emt.lab.labexercise.model.Country;
import emt.lab.labexercise.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://mylibraryemt1.herokuapp.com/")
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAll() {
        return this.countryService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Country country = this.countryService.findById(id);
        if (country != null) return ResponseEntity.ok().body(country);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Country> addCountry (@RequestParam String name,
                                               @RequestParam String continent) {
        Country country = new Country();
        country.setName(name);
        country.setContinent(continent);
        this.countryService.save(country);
        return ResponseEntity.ok(country);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Country> deleteCountry (@PathVariable Long id) {
        this.countryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
