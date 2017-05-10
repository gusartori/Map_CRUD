package com.world;

import com.world.entities.City;
import com.world.entities.Country;
import com.world.entities.State;
import com.world.repository.CityRepository;
import com.world.repository.CountryRepository;
import com.world.repository.StateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapApplicationTests {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CountryRepository  countryRepository;

	@Test
	public void readCity() {
		City city = cityRepository.findOne(1l);
		assertEquals("Botucatu", city.getName());
	}

	@Test
	public void readState() {
		State state = stateRepository.findOne("SP");
		assertEquals("São Paulo", state.getName());
	}

	@Test
	public void readCountry() {
		Country country = countryRepository.findOne("BR");
		assertEquals("Brazil", country.getName());
	}

	@Test
	public void createCity() {
		cityRepository.save(new City("São Carlos","SP"));
		assertEquals("São Carlos", cityRepository.findCityByName("São Carlos").getName());
	}

	@Test
	public void createState() {
		stateRepository.save(new State("RJ","Rio de Janeiro"));
		assertEquals("Rio de Janeiro", stateRepository.findOne("RJ").getName());
	}

	@Test
	public void createCountry() {
		countryRepository.save(new Country("AR","Argentina"));
		assertEquals("Argentina", countryRepository.findOne("AR").getName());
	}

	@Test
	public void updateCity() {
		cityRepository.save(new City("Analandia","SP"));
		City c = cityRepository.findCityByName("Analandia");
		c.setName("Anãolandia");
		cityRepository.save(c);
		assertEquals("Anãolandia", cityRepository.findOne(c.getId()).getName());
	}

	@Test
	public void updateState() {
		stateRepository.save(new State("SC","Santa Catarina"));
		State s = stateRepository.findOne("SC");
		s.setName("Sta Catarina");
		stateRepository.save(s);
		assertEquals("Sta Catarina", stateRepository.findOne("SC").getName());
	}

	@Test
	public void updateCountry() {
		countryRepository.save(new Country("CH","Chile"));
		Country c = countryRepository.findOne("CH");
		c.setName("Chichilele");
		countryRepository.save(c);
		assertEquals("Chichilele", countryRepository.findOne("CH").getName());
	}

	@Test
	public void deleteCity() {
		cityRepository.save(new City("SBS","SP"));
		assertTrue(cityRepository.exists(cityRepository.findCityByName("SBS").getId()));
		cityRepository.delete(cityRepository.findCityByName("SBS"));
		assertNull(cityRepository.findCityByName("Cuscuzeiro"));
	}

	@Test
	public void deleteState() {
		stateRepository.save(new State("MT","Mato Grosso"));
		assertTrue(stateRepository.exists("MT"));
		stateRepository.delete("MT");
		assertNull(stateRepository.findOne("MT"));
	}

	@Test
	public void deleteCountry() {
		countryRepository.save(new Country("BO","Bolivia"));
		assertTrue(countryRepository.exists("BO"));
		countryRepository.delete("BO");
		assertNull(countryRepository.findOne("BO"));
	}
}
