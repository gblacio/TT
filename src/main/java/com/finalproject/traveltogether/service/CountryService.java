package com.finalproject.traveltogether.service;

import com.finalproject.traveltogether.entity.Country;
import com.finalproject.traveltogether.repository.CountryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryDAO countryDAO;

    public List<Country> getAllCountries() {
        return (List<Country>)countryDAO.findAll();
    }
}
