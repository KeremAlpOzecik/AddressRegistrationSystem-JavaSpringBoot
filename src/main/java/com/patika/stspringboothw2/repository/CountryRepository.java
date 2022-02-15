package com.patika.stspringboothw2.repository;

import com.patika.stspringboothw2.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    @Query("SELECT c FROM Country c WHERE c.countryCode=?1")
    Optional<Country> findCountryByCountryCode(String code);

    List<Country> findByCountryCode(String countryCode);
    Optional<Country> findById(Long Id);
}
