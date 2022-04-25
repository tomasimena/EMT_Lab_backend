package emt.lab.labexercise.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import emt.lab.labexercise.model.enumerations.Category;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Integer availableCopies;

    @ManyToOne (fetch = FetchType.EAGER)
    @JsonBackReference
    @ToString.Exclude
    private Author author;

    private Long authorIdValue;

    private Boolean isInGoodCondition;

    @PostPersist
    public void postPersist() {
        this.authorIdValue = this.author.getId();
    }

    @PostUpdate
    public void postUpdate() {
        this.authorIdValue = this.author.getId();
    }

    public Book() {
    }
}
