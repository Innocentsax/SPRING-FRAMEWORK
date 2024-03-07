package dev.InnocentUdo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Long price;
    private boolean available;
    private boolean isVegetarian;
    private boolean isSeasonal;
    private Date creationDate;

    @ManyToMany
    private List<IngredientsItems> ingredients = new ArrayList<>();

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private Category foodCategory;

    @Column(length = 1000)
    @ElementCollection
    private List<String> images;

}
