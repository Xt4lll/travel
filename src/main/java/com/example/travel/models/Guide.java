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
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guide")
    private Long idGuide;

    private String name;
    private String language;
    private Integer experience;

    @ManyToMany
    @JoinTable(
            name = "guide_excursion",
            joinColumns = @JoinColumn(name = "guide_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions;
}
