package com.patika.stspringboothw2.service;

import com.patika.stspringboothw2.entity.Country;
import com.patika.stspringboothw2.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {
  private final CountryRepository countryRepository;

    public void addNewCountry(Country country) {
        Optional<Country> countryOptional=  countryRepository.findCountryByCountryCode(country.getCountryCode());
        if(countryOptional.isPresent())
            throw new IllegalStateException("country code exist");
        countryRepository.save(country);
    }
  public List<Country> findAll(){
      return countryRepository.findAll();
  }
  public List<Country> findByCode(String countryCode){
        List<Country> countryList= countryRepository.findByCountryCode(countryCode);
        return countryList;
  }
  public Optional<Country> findCountry(String countryCode){
      Optional<Country> countryOptional=  countryRepository.findCountryByCountryCode(countryCode);
       return countryOptional;
  }
    public Optional<Country> findById(Long id){return countryRepository.findById(id);}

}
