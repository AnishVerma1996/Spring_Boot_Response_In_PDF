package com.boot.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.boot.app.bean.City;

@Repository
public interface CityRepository extends MongoRepository<City, Integer>
{
	

}