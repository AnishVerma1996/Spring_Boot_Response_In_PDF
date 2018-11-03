package com.boot.app.service;

import java.util.List;

import com.boot.app.bean.City;
import com.boot.app.bean.ResponseStatus;

public interface ICityService {

	public List<City> findAll();
	

   ResponseStatus  saveCity(City city);
}
