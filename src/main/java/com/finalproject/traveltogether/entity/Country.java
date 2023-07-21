package com.finalproject.traveltogether.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="CountryTable", schema = "TravelTogether")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CountryID")
    private int countryID;
    @Column(name="CountryName", nullable = false)
    private String countryName;
}
