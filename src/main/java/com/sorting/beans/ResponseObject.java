package com.sorting.beans;

/**
 * Response Object Bean 
 */
public class ResponseObject {

	private String unsorted;
	private String sorted;
	private String error;
	private String timeTaken;
	private String swapCount;

	public String getUnsorted() {
		return unsorted;
	}

	public void setUnsorted(String unsorted) {
		this.unsorted = unsorted;
	}

	public String getSorted() {
		return sorted;
	}

	public void setSorted(String sorted) {
		this.sorted = sorted;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getSwapCount() {
		return swapCount;
	}

	public void setSwapCount(String swapCount) {
		this.swapCount = swapCount;
	}
}
