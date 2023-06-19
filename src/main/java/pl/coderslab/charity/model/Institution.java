package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

    @Entity
    @Getter
    @Setter
    @ToString
    @Table(name = "institutions")
    public class Institution {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name="name")
        private String name;

        @Column(name="description")
        private String description;

    }


