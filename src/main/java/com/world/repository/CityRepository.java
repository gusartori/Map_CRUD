package com.world.repository;

import com.world.entities.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CityRepository extends CrudRepository<City, Long> {

    City findCityByName(String name);

}
