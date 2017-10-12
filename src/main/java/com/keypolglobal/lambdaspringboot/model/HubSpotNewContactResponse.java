package com.keypolglobal.lambdaspringboot.model;

public class HubSpotNewContactResponse {

	int vid;
	String status;
	String message;
	String correlationId;
	String requestId;
	HubSpotValidationResults validationResults;

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public HubSpotValidationResults getValidationResults() {
		return validationResults;
	}

	public void setValidationResults(HubSpotValidationResults validationResults) {
		this.validationResults = validationResults;
	}	
	
	
}
