package com.sorting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sorting.utils.NumberSortingUtil;
import com.sorting.beans.ResponseMessage;

/**
 * ServiceController routes the incoming ReST service calls.
 */
@RestController
@EnableAutoConfiguration
public class ServiceController {

	/**
	 * Number sorting utility
	 */
	@Autowired
	private NumberSortingUtil numberSortingUtil;

	/**
	 * SortedNumbers method takes unsorted numbers input and returns sorted
	 * number list
	 */
	@GetMapping("/sortedNumbers")
	public ResponseMessage getSortedNumbers(@RequestParam(value = "unsortedNumbers") final String unsortedNumbers) {

		return numberSortingUtil.handleSortingRequest(unsortedNumbers);
		
	}
}