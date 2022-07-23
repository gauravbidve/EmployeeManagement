package com.jbk.Employee_Management.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Employee_Management.entity.Country;

@Repository
public class CountryDaoImpl implements CountryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addCountry(Country country) {
		
		Session session = null;
		boolean value = false;
		
		try {
			session = sessionFactory.openSession();
			Country ctry = session.get(Country.class, country.getCid());
			
			if(ctry==null) {
				Criteria criteria = session.createCriteria(Country.class);
				criteria.add(Restrictions.eq("cname", country.getCname()));
				Country cntry = (Country)criteria.uniqueResult();
				if(cntry==null) {
				Transaction transaction = session.beginTransaction();
				session.save(country);
				transaction.commit();
				value = true;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return value;
	}

	@Override
	public List<Country> getAllCountry() {

		Session session = null;
		List<Country> countries = new ArrayList<>();

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			countries = criteria.list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return countries;
	}

	@Override
	public Country getParticularCountry(int cid) {
		
		Session session = null;
		Country country = null;
		
		try {
			session = sessionFactory.openSession();
			country = session.get(Country.class, cid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return country;
	}

	@Override
	public boolean updateCountry(Country country) {
		
		Session session = null;
		boolean value = false;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			criteria.add(Restrictions.eq("cname", country.getCname()));
			Country ctry = (Country)criteria.uniqueResult();
			
			if(ctry==null) {
				Transaction transaction = session.beginTransaction();
				session.update(country);
				transaction.commit();
				value=true;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return value;
	}

	@Override
	public boolean deleteCountry(int cid) {
		
		Session session = null;
		boolean value = false;
		
		try {
			session = sessionFactory.openSession();
			Country ctry = session.get(Country.class, cid);
			
			if(ctry!=null) {
				Transaction transaction = session.beginTransaction();
				session.delete(ctry);
				transaction.commit();
				value = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return value;
	}

}
