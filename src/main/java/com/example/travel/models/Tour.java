package com.example.travel.models;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tour")
    private Long idTour;

    private String name;
    private String country;
    private String city;
    private Integer duration;
    private Double price;

    @ManyToMany
    @JoinTable(
            name = "tour_excursion",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions;

    @ManyToMany
    @JoinTable(
            name = "tour_hotel",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "hotel_id"))
    private Set<Hotel> hotels;
}
