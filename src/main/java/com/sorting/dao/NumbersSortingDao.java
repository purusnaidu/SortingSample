package com.sorting.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sorting.beans.NumbersSorting;

/**
 * DB access layer
 */
@Repository
public class NumbersSortingDao {
	
	/**
	 * DB entity manager
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * To insert data to DB. 
	 */
	public void create(NumbersSorting inputRequest) {
		entityManager.persist(inputRequest);
	}

	/**
	 * To fetch all SortedNumbersList results from DB 
	 */
	@SuppressWarnings("unchecked")
	public List<NumbersSorting> getSortedNumbersList() {
		Query query = entityManager.createNamedQuery("findAllSortedNumbersSQL");
		return query.getResultList();
	}
}