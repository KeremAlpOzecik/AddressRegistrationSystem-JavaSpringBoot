package com.patika.stspringboothw2.entity;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "street")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetName;
    private String doorNumber;
    private String aptNumber;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "street_neighbor",referencedColumnName = "id")
    private Neighborhood neighborhood;
}
