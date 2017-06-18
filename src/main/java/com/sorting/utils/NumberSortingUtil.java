package com.sorting.utils;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.sorting.beans.NumbersSorting;
import com.sorting.beans.ResponseMessage;
import com.sorting.beans.ResponseObject;
import com.sorting.service.NumberSortingService;
/**
 *  Number sorting utility class 
 *
 */
@Configuration
public class NumberSortingUtil {
	
	@Autowired
	private NumberSortingService sortingSvc;
	
	private int swapCount=-1;

	/**
	 * This utility method sort manually and return the number list.
	 */
	private String manualSorting(String unsortedNumbers) throws Exception {

		swapCount=0;
		String[] unsortedArray = unsortedNumbers.split(",");
		int parsedNumbersArray[] = new int[unsortedArray.length];

		int numberArrayIndex = 0;

		for (String valueAtIndex : unsortedArray) {
				if (!StringUtils.isBlank(valueAtIndex)) {
					parsedNumbersArray[numberArrayIndex++] = Optional.ofNullable(valueAtIndex)
							.map(Integer::valueOf).orElse(null);
				}

		}

		String sortedNumbers = "";
		int swapVar = -1;

		for (int i = 0; i < parsedNumbersArray.length; i++) {
			for (int j = i + 1; j < parsedNumbersArray.length; j++) {
				if (parsedNumbersArray[i] > parsedNumbersArray[j]) {
					swapVar = parsedNumbersArray[i];
					parsedNumbersArray[i] = parsedNumbersArray[j];
					parsedNumbersArray[j] = swapVar;
					swapCount++;
				}
			}
		}

		if (parsedNumbersArray.length > 0) {
			for (int j = 0; j < parsedNumbersArray.length; j++) {
				if (j == 0) {
					sortedNumbers = StringUtils.EMPTY + parsedNumbersArray[j];
				} else {
					sortedNumbers = sortedNumbers + "," + parsedNumbersArray[j];
				}
			}
		}
		
		return sortedNumbers;
	}


	/**
	 * creating error response from common place
	 */
	public ResponseObject[] createErrorResponse(String unsortedNumbers) {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setUnsorted(unsortedNumbers);
		responseObject.setError("Enter a valid comma seperated numeric values");
		return new ResponseObject[] { responseObject };
	}

	/**
	 * to handle the incoming REST service request 
	 */
	public ResponseMessage handleSortingRequest(String unsortedNumbers) {
		
		ResponseMessage responseMessage = new ResponseMessage();
		ResponseObject[] respObjArray = null;

		String sortedNumbers = "";

		try {
			NumbersSorting numbersSorting = new NumbersSorting();
			numbersSorting.setInputNumbers(unsortedNumbers);

			long startTime = System.nanoTime();
			 sortedNumbers = manualSorting(unsortedNumbers);
			 numbersSorting.setSwapCount(swapCount);
			numbersSorting.setSortedNumbers(sortedNumbers);
			long endTime = System.nanoTime();

			double timeTaken = (endTime - startTime) / 1000000.0;
			numbersSorting.setTimeTaken((timeTaken) + " milliseconds");

			if (!StringUtils.isBlank(sortedNumbers)) {
				// Persist sorted,unsorted,timetaken values to DB.
				sortingSvc.create(numbersSorting);
				responseMessage.setResponseType("success");
				respObjArray = sortingSvc.getSortedNumbersList();
				responseMessage.setResponseObject(respObjArray);
			}

		} catch (Exception e) {
			Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, e.getMessage());
		}

		if (StringUtils.isBlank(sortedNumbers)) {
			responseMessage.setResponseType("error");
			responseMessage.setResponseObject(createErrorResponse(unsortedNumbers));
		}
		return responseMessage;

	}

}
