package com.patika.stspringboothw2.repository;

import com.patika.stspringboothw2.entity.Neighborhood;
import com.patika.stspringboothw2.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood,Long> {
    @Query("SELECT n FROM Neighborhood n WHERE n.neighName=?1")
    Optional<Neighborhood> findNeighborhoodByNeigName(String neighName);
    List<Neighborhood> findByTown_TownName(String townName);
}
