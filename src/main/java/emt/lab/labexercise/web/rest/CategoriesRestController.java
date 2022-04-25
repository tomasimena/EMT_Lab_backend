package emt.lab.labexercise.web.rest;

import emt.lab.labexercise.model.Category;
import emt.lab.labexercise.repository.CategoryRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://mylibraryemt1.herokuapp.com/")
@RequestMapping("/api/categories")
public class CategoriesRestController {

    private final CategoryRepository categoryRepository;

    public CategoriesRestController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

}
