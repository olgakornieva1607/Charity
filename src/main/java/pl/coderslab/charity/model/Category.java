package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

}
