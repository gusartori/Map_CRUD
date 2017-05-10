package com.world.repository;

import com.world.entities.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StateRepository extends CrudRepository<State, String>{

}
