package com.patika.stspringboothw2.service;

import com.patika.stspringboothw2.entity.Country;
import com.patika.stspringboothw2.entity.Province;
import com.patika.stspringboothw2.entity.Town;
import com.patika.stspringboothw2.repository.ProvinceRepository;
import com.patika.stspringboothw2.repository.TownRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TownService {
    private final TownRepository townRepository;
    private final ProvinceRepository provinceRepository;

    public void addNewTown(Town town) {
        Optional<Town> townOptional=  townRepository.findTownByTownName(town.getTownName());
        if(townOptional.isPresent())
            throw new IllegalStateException("Town exist");
        town.setProvince(provinceRepository.findById(town.getProvinceId()).get());
        townRepository.save(town);
    }
    public List<Town> findAll(){return townRepository.findAll();
    }


    public List<Town> findProvinceTowns(String provinceName){
        return townRepository.findByProvince_ProvinceName(provinceName);
    }
}
