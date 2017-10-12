package com.keypolglobal.lambdaspringboot.dto;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.keypolglobal.lambdaspringboot.model.ContactForm;
import com.keypolglobal.lambdaspringboot.model.HubSpotNewContactResponse;
import com.keypolglobal.lambdaspringboot.model.HubspotContactParent;
import com.keypolglobal.lambdaspringboot.model.HubspotContactProperties;

public class ContactFormDTO {

	public ContactFormDTO () {
		
	}
	
	public HubSpotNewContactResponse hubSpotContactAdd (ContactForm contactForm) throws JsonProcessingException{
		String name = contactForm.getFirstname();
		System.out.println(name);
		
		
		
		
		ArrayList<HubspotContactProperties> properties = new ArrayList<HubspotContactProperties>();
		
		HubspotContactProperties hubspotContactPropertiesEmail = new HubspotContactProperties();
		hubspotContactPropertiesEmail.setProperty("email");
		hubspotContactPropertiesEmail.setValue(contactForm.getEmail());
		
		properties.add(hubspotContactPropertiesEmail);
		
		HubspotContactProperties hubspotContactPropertiesfirstname = new HubspotContactProperties();
		hubspotContactPropertiesfirstname.setProperty("firstname");
		hubspotContactPropertiesfirstname.setValue(contactForm.getFirstname());
		
		properties.add(hubspotContactPropertiesfirstname);
		
		HubspotContactProperties hubspotContactPropertiesLastname = new HubspotContactProperties();
		hubspotContactPropertiesLastname.setProperty("lastname");
		hubspotContactPropertiesLastname.setValue(contactForm.getLastname());
		
		properties.add(hubspotContactPropertiesLastname);
		
		HubspotContactProperties hubspotContactPropertiesPhone = new HubspotContactProperties();
		hubspotContactPropertiesPhone.setProperty("phone");
		hubspotContactPropertiesPhone.setValue(contactForm.getPhone());
		
		properties.add(hubspotContactPropertiesPhone);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		String propertiesJson = null;
		
		try {
			propertiesJson = mapper.writeValueAsString(properties);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newHubspotContact = "{\"properties\":" + propertiesJson + "}";
		System.out.println(newHubspotContact);
		
		String url = "https://api.hubapi.com/contacts/v1/contact/?hapikey=0b047785-ad88-4325-a032-fe351a641a69";
		String url1 = "http://localhost:8080/rest/submitcontactform/testpost";
		RestTemplate template=new RestTemplate();
		
		HubSpotNewContactResponse hubSpotNewContactResponse = template.postForObject(url, newHubspotContact, HubSpotNewContactResponse.class);
		System.out.println(hubSpotNewContactResponse.getVid());
		
		return hubSpotNewContactResponse;
	}
	
}
