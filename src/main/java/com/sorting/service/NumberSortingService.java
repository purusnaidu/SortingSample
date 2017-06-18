package com.sorting.service;

import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.sorting.beans.NumbersSorting;
import com.sorting.beans.ResponseObject;
import com.sorting.dao.NumbersSortingDao;

/**
 *  Number Sorting Service, abstracts DAO layer
 *  and data manipulation operations.
 */
@Transactional
@Configuration
public class NumberSortingService {

	@Autowired
	private NumbersSortingDao numberSortingDao;
	
	@Autowired
    private DozerBeanMapper dozerBeanMapper;

	/**
	 * Create method Persists data to DB through DAO
	 */
	public void create(NumbersSorting numbersSorting) {
		numberSortingDao.create(numbersSorting);
	}

	/**
	 * Fetches All historic records/sorted values 
	 */
	public ResponseObject[] getSortedNumbersList() {
		return convertMappedBeans(numberSortingDao.getSortedNumbersList());
	}
	
	/**
	 *  Transforms the DB results data to ResponseObjects.
	 *  users Dozer  
	 */
	public ResponseObject[] convertMappedBeans(List<NumbersSorting> lst){
		
		ResponseObject[] respObjArr=new ResponseObject[lst.size()];
		
		int index=0;		
		for (NumbersSorting numbersSorting : lst) {
			ResponseObject resp = dozerBeanMapper.map(numbersSorting, ResponseObject.class);
			respObjArr[index++]=resp;
		}		
		return respObjArr;
	}
}