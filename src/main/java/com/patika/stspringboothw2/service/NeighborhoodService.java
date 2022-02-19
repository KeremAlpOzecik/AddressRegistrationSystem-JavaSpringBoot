package com.patika.stspringboothw2.service;

import com.patika.stspringboothw2.entity.Neighborhood;
import com.patika.stspringboothw2.entity.Town;
import com.patika.stspringboothw2.repository.NeighborhoodRepository;
import com.patika.stspringboothw2.repository.TownRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NeighborhoodService {
    private final NeighborhoodRepository neighborhoodRepository;
    private final TownRepository townRepository;

    public void addNeighborhood(Neighborhood neighborhood){
        neighborhood.setTown(townRepository.findById(neighborhood.getTownId()).get());
        neighborhoodRepository.save(neighborhood);

    }

    @Transactional
    public void updateNeighborhood(Long neighorhoodId,String name) {
        Neighborhood neighborhood=neighborhoodRepository.findById(neighorhoodId)
                .orElseThrow(()->new IllegalStateException(neighorhoodId+" does not exist"));
        if(name !=null && name.length()>0 && !Objects.equals(neighborhood.getNeighName(),name)){
            neighborhood.setNeighName(name);
        }
    }

    public List<Neighborhood> findAllNeigborhood() {
    return     neighborhoodRepository.findAll();
    }
    public List<Neighborhood> findTownNeighborhoods(String townName){
        return neighborhoodRepository.findByTown_TownName(townName);
    }
}
