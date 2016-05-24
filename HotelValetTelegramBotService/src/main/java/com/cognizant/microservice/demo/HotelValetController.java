package com.cognizant.microservice.demo;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/valet")
public class HotelValetController {

	private final static Logger LOGGER = Logger.getLogger(HotelValetController.class.getName()); 
    private final static String CLASSNAME="HotelValetController";

    
    @RequestMapping(value="/process",method=RequestMethod.POST)
    public void process(@RequestBody String payload) {
    	String methodName="process";
    	LOGGER.entering(CLASSNAME, methodName);
    	System.out.println("Request body is:"+payload);
        
       // return null;
        
        
        
    }
   
    
}
