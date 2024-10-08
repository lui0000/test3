package com.eliza.testing.services;

import com.eliza.testing.models.City;
import com.eliza.testing.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public boolean isCityExists(String name) {
        return cityRepository.existsByCityName(name);
    }


    public boolean isCorrect(String previousCity, String currentCity) {
        char lastLetterPrevious = Character.toLowerCase(previousCity.charAt(previousCity.length() - 1));
        char firstLetterCurrent = Character.toLowerCase(currentCity.charAt(0));

        return lastLetterPrevious == firstLetterCurrent;
    }
}
