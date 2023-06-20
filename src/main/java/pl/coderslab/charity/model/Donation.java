package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name="donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="quantity")
    private Integer quantity;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institution_id", nullable = false)
    private Institution institution;

    @Column(name="street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="zipCode")
    private String zipCode;

    @Column(name="pickUpDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @Column(name="pickUpTime")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;

    @Column(name="pickUpComment")
    private String pickUpComment;

}
