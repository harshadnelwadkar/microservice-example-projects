/**
 * 
 */
package com.microservice.two.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author harshadnelwadkar
 *
 */
@RestController
@RequestMapping("two")
public class ConfigClientTestController {

	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Value("${hello.service}")
	private String helloService;
	
	@Value("${service.two.code}")
	private String serviceTwoCode;
	
	@GetMapping(path = "/welcome-message")
	public String welcomeMessage() {
		
		return welcomeMessage;
	}
	
	@GetMapping(path = "/hello-service")
	public String helloService() {
		
		return welcomeMessage;
	}
	
	@GetMapping(path = "/service-two-code")
	public String serviceTwoCode() {
		
		return serviceTwoCode;
	}
	
	
}
