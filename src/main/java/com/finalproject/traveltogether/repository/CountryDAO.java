package com.finalproject.traveltogether.repository;

import com.finalproject.traveltogether.entity.Country;
import com.finalproject.traveltogether.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDAO extends JpaRepository<Country, Long> {
    public User findByCountryName(String countryName);
}
