package com.keypolglobal.lambdaspringboot.spring;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.keypolglobal.lambdaspringboot.dto.ContactFormDTO;
import com.keypolglobal.lambdaspringboot.model.ContactForm;
import com.keypolglobal.lambdaspringboot.model.HubSpotNewContactResponse;


@RestController
@RequestMapping(value="/rest/submitcontactform")
public class ContactFormService {
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	   public ContactForm getcontactform(){
	    ContactForm  contactform = new ContactForm();
	    contactform.setFirstname("Michael");
	    contactform.setEmail("brosnan.michael@gmail.com");
	    contactform.setPhone("0861708774");
	    contactform.setMessage("I am making an enquiry");
	    contactform.setStatusCode(300);
	    
		return contactform;
	   }
	@RequestMapping(value="/add",method = RequestMethod.POST)
		public HubSpotNewContactResponse addcontact(@RequestBody ContactForm contactForm) {
			String fisrtname = contactForm.getFirstname();
			System.out.println(fisrtname);
			ContactFormDTO contactFormDTO = new ContactFormDTO();
			HubSpotNewContactResponse hubSpotNewContactResponse = new HubSpotNewContactResponse();
			try {
				hubSpotNewContactResponse = contactFormDTO.hubSpotContactAdd(contactForm);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return hubSpotNewContactResponse;
		}
	
	@RequestMapping(value="/testpost",method = RequestMethod.POST)
	public String testpost(@RequestBody String contactFormString) {
		System.out.println(contactFormString);
		return "Success";
	}
	
	
}
