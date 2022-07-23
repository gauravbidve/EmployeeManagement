package com.jbk.Employee_Management.dao;

import java.util.List;

import com.jbk.Employee_Management.entity.Country;

public interface CountryDao {
	
	public boolean addCountry(Country country);
	public List<Country> getAllCountry();
	public Country getParticularCountry(int cid);
	public boolean updateCountry(Country country);
	public boolean deleteCountry(int cid);
	
}
