package emt.lab.labexercise.model.dto;


import emt.lab.labexercise.model.enumerations.Category;
import lombok.Data;


@Data
public class BookDto {

    private String name;

    private Category category;

    private Integer availableCopies;

    private Long authorId;

    private Boolean isInGoodCondition;

    public BookDto(String name, Category category, Integer availableCopies, Long authorId, Boolean isInGoodCondition) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.authorId = authorId;
        this.isInGoodCondition = isInGoodCondition;
    }

    public BookDto(String name, Category category, Integer availableCopies, Long authorId) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.authorId = authorId;
    }

    public BookDto() {

    }
}
