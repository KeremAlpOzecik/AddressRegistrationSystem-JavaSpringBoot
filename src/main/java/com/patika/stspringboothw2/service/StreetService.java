package com.patika.stspringboothw2.service;

import com.patika.stspringboothw2.entity.Neighborhood;
import com.patika.stspringboothw2.entity.Street;
import com.patika.stspringboothw2.repository.NeighborhoodRepository;
import com.patika.stspringboothw2.repository.StreetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StreetService {
    private final StreetRepository streetRepository;
    private final NeighborhoodRepository neighborhoodRepository;
    public void addStreet(Street street)
    {   street.setNeighborhood(neighborhoodRepository.findById(street.getNeighId()).get());
        streetRepository.save(street);
    }

    @Transactional
    public void updateStreet(Long streetId,String name) {
        Street street=streetRepository.findById(streetId)
                .orElseThrow(()->new IllegalStateException(streetId+" does not exist"));
        if(name !=null && name.length()>0 && !Objects.equals(street.getStreetName(),name)){
            street.setStreetName(name);
        }
    }

    public List<Street> findAllStreet() {
        return  streetRepository.findAll();
    }
    public List<Street> findNeighborhoodStreets(String neighName){
        return streetRepository.findByNeighborhood_NeighName(neighName);
    }
}
