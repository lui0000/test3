package com.eliza.testing.util;

import com.eliza.testing.models.City;
import com.eliza.testing.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CityValidator implements Validator {

    private final CityService cityService;

    @Autowired
    public CityValidator(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return City.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
