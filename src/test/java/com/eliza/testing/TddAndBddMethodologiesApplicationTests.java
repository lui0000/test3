package com.eliza.testing;

import com.eliza.testing.models.City;
import com.eliza.testing.repositories.CityRepository;
import com.eliza.testing.services.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;

@SpringBootTest
class TddAndBddMethodologiesApplicationTests {


	private final DataSource dataSource;
	private final CityRepository cityRepository;
	private final CityService cityService;

	@Autowired
	public TddAndBddMethodologiesApplicationTests(DataSource dataSource, CityRepository cityRepository, CityService cityService) {
		this.dataSource = dataSource;
		this.cityRepository = cityRepository;
        this.cityService = cityService;
    }

	@Test
	void databaseConnectionTest() {
		assertNotNull(dataSource, "DataSource should not be null");
	}
	@Test
	void CityExistTest() {
		boolean test = cityService.isCityExists("Вологда");
		assertTrue(test, "City Вологда should exist in the database");
	}
	@Test
	void FollowTheRulesOfTheGameTest () {
		boolean test = cityService.isCorrect("Москва", "Анапа");
		assertTrue(test, "The first letter of the current city should match the last letter of the previous city.");
	}


}
