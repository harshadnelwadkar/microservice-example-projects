/**
 * 
 */
package com.microservice.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import exception.ServiceTestException;

/**
 * @author harshadnelwadkar
 *
 */
@RestController
@RequestMapping("one")
public class ConfigClientTestController {

	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Value("${hello.service}")
	private String helloService;
	
	@Value("${service.one.code}")
	private String serviceOneCode;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path = "/welcome-message")
	public String welcomeMessage() {
		
		return welcomeMessage;
	}
	
	@GetMapping(path = "/hello-service")
	public String helloService() {
		
		return welcomeMessage;
	}
	
	@GetMapping(path = "/service-one-code")
	public String serviceOneCode() {
		
		//throw new ServiceTestException("Exception throws at service one !!!");
		
		return restTemplate.getForObject("http://localhost:8089/zero/get-exception", String.class);
	}
	
	
}
