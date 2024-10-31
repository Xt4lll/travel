package com.example.travel.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public")
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_excursion")
    private Long idExcursion;

    private String name;
    private String description;
    private Double price;

    @ManyToMany(mappedBy = "excursions")
    private Set<Tour> tours;
}