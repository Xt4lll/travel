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
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transport")
    private Long idTransport;

    private String type;
    private Integer capacity;
    private String operator;

    @ManyToMany
    @JoinTable(
            name = "tour_transport",
            joinColumns = @JoinColumn(name = "transport_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_id"))
    private Set<Tour> tours;
}

