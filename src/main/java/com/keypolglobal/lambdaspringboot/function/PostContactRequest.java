package com.keypolglobal.lambdaspringboot.function;

import java.io.IOException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keypolglobal.lambdaspringboot.dto.ContactFormDTO;
import com.keypolglobal.lambdaspringboot.model.ContactForm;
import com.keypolglobal.lambdaspringboot.model.HubSpotNewContactResponse;
import com.keypolglobal.lambdaspringboot.model.ServerlessInput;
import com.keypolglobal.lambdaspringboot.model.ServerlessOutput;


public class PostContactRequest implements RequestHandler<ServerlessInput, ServerlessOutput> {

    @Override
    public ServerlessOutput handleRequest(ServerlessInput serverlessInput, Context context) {
	
    	ContactForm contactForm = new ContactForm();
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			contactForm = mapper.readValue(serverlessInput.getBody(), ContactForm.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	ContactFormDTO contactFormDTO = new ContactFormDTO();
		HubSpotNewContactResponse hubSpotNewContactResponse = new HubSpotNewContactResponse();
		try {
			hubSpotNewContactResponse = contactFormDTO.hubSpotContactAdd(contactForm);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 ObjectMapper mapperOutput = new ObjectMapper();
		 String jsonResponse = null;
		 try {
			 jsonResponse = mapperOutput.writeValueAsString(hubSpotNewContactResponse);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
    	ServerlessOutput output = new ServerlessOutput();
    	output.setBody(jsonResponse);
    	output.setStatusCode(200);
    	
	 return output;
    }
}
