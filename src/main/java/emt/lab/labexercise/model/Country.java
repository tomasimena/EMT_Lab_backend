package emt.lab.labexercise.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String continent;

    @OneToMany (mappedBy = "country", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Author> authors;

    public Country() {
    }
}
