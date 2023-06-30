package pl.coderslab.charity.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
        private Long id;

        @NotBlank
        @Size(min = 2, max = 50)
        @Column(name="name")
        private String name;

        @NotBlank
        @Size(min = 2, max = 100)
        @Column(name="description")
        private String description;

    }


