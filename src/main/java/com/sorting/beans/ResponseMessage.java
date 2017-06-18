package com.sorting.beans;

/**
 *  To create response object and add a response type to it. 
 *
 */
public class ResponseMessage {

	private ResponseObject[] responseObject;

	private String responseType;

	public ResponseObject[] getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(ResponseObject[] responseObject) {
		this.responseObject = responseObject;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

}
