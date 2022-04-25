package emt.lab.labexercise.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne (fetch = FetchType.EAGER)
    @JsonBackReference
    private Country country;

    @OneToMany (mappedBy = "author", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Book> books;

    public Author() {
    }
}
