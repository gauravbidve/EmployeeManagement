package com.jbk.Employee_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Employee_Management.dao.CountryDao;
import com.jbk.Employee_Management.entity.Country;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryDao dao;
	
	@Override
	public boolean addCountry(Country country) {
		boolean value = dao.addCountry(country);
		return value;
	}

	@Override
	public List<Country> getAllCountry() {
		List<Country> countries = dao.getAllCountry();
		return countries;
	}

	@Override
	public Country getParticularCountry(int cid) {
		Country country = dao.getParticularCountry(cid);
		return country;
	}

	@Override
	public boolean updateCountry(Country country) {
		boolean value = dao.updateCountry(country);
		return value;
	}

	@Override
	public boolean deleteCountry(int cid) {
		boolean value = dao.deleteCountry(cid);
		return value;
	}

}
