package com.eliza.testing.repositories;

import com.eliza.testing.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    boolean existsByCityName(String cityName);

}
