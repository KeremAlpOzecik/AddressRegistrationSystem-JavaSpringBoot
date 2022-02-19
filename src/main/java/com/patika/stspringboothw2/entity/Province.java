package com.patika.stspringboothw2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "province")
public class Province implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String provinceName;
    private String plateCode;



    @Column(name = "country_id", nullable=false)
    private Long country_id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "country_id", insertable=false, updatable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Country country;





}
