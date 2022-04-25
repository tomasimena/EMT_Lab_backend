package emt.lab.labexercise.bootstrap;

import emt.lab.labexercise.model.Author;
import emt.lab.labexercise.model.Book;
import emt.lab.labexercise.model.Country;
import emt.lab.labexercise.model.enumerations.Category;
import emt.lab.labexercise.repository.CategoryRepository;
import emt.lab.labexercise.service.AuthorService;
import emt.lab.labexercise.service.BookService;
import emt.lab.labexercise.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class AppInitializer {

    private final AuthorService authorService;
    private final CountryService countryService;
    private final BookService bookService;
    private final CategoryRepository categoryRepository;

    public AppInitializer(AuthorService authorService, CountryService countryService, BookService bookService, CategoryRepository categoryRepository) {
        this.authorService = authorService;
        this.countryService = countryService;
        this.bookService = bookService;
        this.categoryRepository = categoryRepository;
    }


    //@PostConstruct
    public void initialize() {

        for (Category category : Category.values()) {
            emt.lab.labexercise.model.Category categoryModel = new emt.lab.labexercise.model.Category();
            categoryModel.setCategory(category);
            categoryRepository.save(categoryModel);
        }

        Country country = new Country();
        country.setName("China");
        country.setContinent("Asia");


        countryService.save(country);

        country = countryService.findByName("China");

        Author author = new Author();
        author.setName("Name1");
        author.setSurname("Surname1");
        author.setCountry(country);
        authorService.save(author);

        author = new Author();

        author.setName("NewName1");
        authorService.save(author);
        author = new Author();
        author.setName("Name2");
        author.setSurname("Surname2");
        author.setCountry(country);
        authorService.save(author);

        Book book = new Book();
        book.setIsInGoodCondition(false);
        book.setName("Harry Motter");
        book.setCategory(Category.DRAMA);
        book.setAuthor(authorService.findAllByName("Name1").stream().findFirst().orElse(null));
        book.setAvailableCopies(2);
        bookService.save(book);

        Optional<Author> author1 = authorService.findAllByName("Name1").stream().findFirst();
        author1.ifPresent(value -> value.getBooks().add(book));

    }

}
