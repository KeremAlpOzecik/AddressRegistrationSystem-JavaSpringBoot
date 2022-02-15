package com.patika.stspringboothw2.repository;

import com.patika.stspringboothw2.entity.Country;
import com.patika.stspringboothw2.entity.Province;
import com.patika.stspringboothw2.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Long> {
    @Query("SELECT p FROM Province p WHERE p.plateCode=?1")
    Optional<Province> findProvinceByPlateCode(String code);

    List<Province> findByPlateCode(String plateCode);





}
