package com.world.repository;

import com.world.entities.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, String>{
}
