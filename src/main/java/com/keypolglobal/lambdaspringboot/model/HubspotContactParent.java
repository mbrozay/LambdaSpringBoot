package com.keypolglobal.lambdaspringboot.model;

import java.util.ArrayList;

public class HubspotContactParent {
	String title;
	ArrayList<HubspotContactProperties> hubspotContactProperties;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<HubspotContactProperties> getHubspotContactProperties() {
		return hubspotContactProperties;
	}
	public void setHubspotContactProperties(ArrayList<HubspotContactProperties> hubspotContactProperties) {
		this.hubspotContactProperties = hubspotContactProperties;
	}

}
