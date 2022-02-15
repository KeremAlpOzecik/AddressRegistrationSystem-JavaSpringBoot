package com.patika.stspringboothw2.service;

import com.patika.stspringboothw2.entity.Country;
import com.patika.stspringboothw2.entity.Province;
import com.patika.stspringboothw2.entity.Town;
import com.patika.stspringboothw2.repository.CountryRepository;
import com.patika.stspringboothw2.repository.ProvinceRepository;
import com.patika.stspringboothw2.repository.TownRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProvinceService {
    private final ProvinceRepository provinceRepository;
    private final CountryService countryService;


    public void addNewProvince(Province province) {

        Optional<Province> provinceOptional= provinceRepository.findProvinceByPlateCode(province.getPlateCode());
        if(provinceOptional.isPresent())
            throw new IllegalStateException("Province exist");


        provinceRepository.save(province);
    }
    public List<Province> findByPlateCode(String plateCode){
        List<Province> provinceList= provinceRepository.findByPlateCode(plateCode);
        return provinceList;
    }
    public List<Province> findAllProvince(){
        return provinceRepository.findAll();
    }




}
