package emt.lab.labexercise.web.rest;

import emt.lab.labexercise.model.Author;
import emt.lab.labexercise.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://mylibraryemt1.herokuapp.com/")
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAll() {
        return this.authorService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author = this.authorService.findById(id);
        if (author != null) return ResponseEntity.ok().body(author);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Author> addAuthor (@RequestParam String name,
                                             @RequestParam String surname) {
        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);
        this.authorService.save(author);
        return ResponseEntity.ok(author);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Author> deleteAuthor (@PathVariable Long id) {
        this.authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
