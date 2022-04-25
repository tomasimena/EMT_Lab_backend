package emt.lab.labexercise.repository;

import emt.lab.labexercise.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findAllByCategory(emt.lab.labexercise.model.enumerations.Category category);

}
