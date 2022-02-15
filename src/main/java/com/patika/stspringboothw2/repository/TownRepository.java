package com.patika.stspringboothw2.repository;

import com.patika.stspringboothw2.entity.Province;
import com.patika.stspringboothw2.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town,Long> {
    @Query("SELECT t FROM Town t WHERE t.townName=?1")
    Optional<Town> findTownByTownName(String townName);

   List<Town> findByProvince_ProvinceName(String provinceName);


}
