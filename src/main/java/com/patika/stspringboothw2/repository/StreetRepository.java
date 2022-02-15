package com.patika.stspringboothw2.repository;

import com.patika.stspringboothw2.entity.Neighborhood;
import com.patika.stspringboothw2.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StreetRepository extends JpaRepository<Street,Long> {
    List<Street> findByNeighborhood_NeighName(String neighName);

}
