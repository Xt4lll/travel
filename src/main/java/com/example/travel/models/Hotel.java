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
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Long idHotel;

    private String name;
    private String address;
    private Integer stars;
    private Double pricePerNight;

    @ManyToMany(mappedBy = "hotels")
    private Set<Tour> tours;
}

