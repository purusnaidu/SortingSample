package com.sorting.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * NumberSorting Bean
 */
@Entity
@Table(name = "numbers_sorting")
@NamedNativeQueries({ @NamedNativeQuery(name = "findAllSortedNumbersSQL", query = "select * from numbers_sorting u", resultClass = NumbersSorting.class) })
public class NumbersSorting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "input_numbers")
	private String inputNumbers;
	
	@Column(name = "sorted_numbers")
	private String sortedNumbers;
	
	@Column(name = "time_taken")
	private String timeTaken;
	
	@Column(name="swap_count")
	private int swapCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInputNumbers() {
		return inputNumbers;
	}

	public void setInputNumbers(String inputNumbers) {
		this.inputNumbers = inputNumbers;
	}

	public String getSortedNumbers() {
		return sortedNumbers;
	}

	public void setSortedNumbers(String sortedNumbers) {
		this.sortedNumbers = sortedNumbers;
	}

	public String getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}

	public int getSwapCount() {
		return swapCount;
	}

	public void setSwapCount(int swapCount) {
		this.swapCount = swapCount;
	}

}