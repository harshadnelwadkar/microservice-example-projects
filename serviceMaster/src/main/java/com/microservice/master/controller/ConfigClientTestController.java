/**
 * 
 */
package com.microservice.master.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author harshadnelwadkar
 *
 */
@RestController
@RequestMapping("master")
public class ConfigClientTestController {

	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Value("${hello.service}")
	private String helloService;
	
	@Value("${master.service.code}")
	private String masterServiceCode;
	
	private static Logger log = LogManager.getFormatterLogger(ConfigClientTestController.class);
			
	@GetMapping(path = "/welcome-message")
	public String welcomeMessage() {
		log.debug(welcomeMessage);
		return welcomeMessage;
	}
	
	@GetMapping(path = "/hello-service")
	public String helloService() {
		log.debug("helloService =>{0}", welcomeMessage);

		return welcomeMessage;
	}
	
	@GetMapping(path = "/master-service-code")
	public String masterServiceCode() {
		log.debug("masterServiceCode =>{0}", masterServiceCode);

		return masterServiceCode;
	}
	
	
}
