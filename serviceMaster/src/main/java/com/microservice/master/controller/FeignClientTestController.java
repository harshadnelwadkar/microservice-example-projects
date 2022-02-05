/**
 * 
 */
package com.microservice.master.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.master.data.ServiceData;
import com.microservice.master.service.ServiceOneFeignClient;
import com.microservice.master.service.ServiceTwoFeignClient;

import lombok.extern.slf4j.Slf4j;

/**
 * @author harshadnelwadkar
 *
 */
@RestController
@RequestMapping("master")
@Slf4j
public class FeignClientTestController {
	
	@Autowired
	private ServiceOneFeignClient serviceOneFeignClient;
	
	@Autowired
	private ServiceTwoFeignClient serviceTwoFeignClient;
	
	private static Logger log = Logger.getLogger(FeignClientTestController.class.getName());
	
	@GetMapping(path = "/hello-one")
	public String sayHelloServiceOne() {
		log.info("In the method. Path :- /hello-one ");
		return serviceOneFeignClient.sayHello();
	}

	@GetMapping(path = "/service-info-one")
	public String getServerOneInfoCall(HttpServletRequest request) {
		log.info("In the method. Path :- /service-info-one");
		
		return serviceOneFeignClient.getServerOneInfo(request);
	}
		
	
	@GetMapping(path = "/hello-service-one")
	public String helloServiceOne() {
		log.info("In the method. Path :- /hello-service-one");
		
		return serviceOneFeignClient.helloService();
	}
	
	
	@GetMapping(path = "/service-one-code")
	public String serviceOneCode() {
		log.info("In the method of Controller");
		
		return serviceOneFeignClient.serviceOneCode();
	}
	
	@GetMapping(path = "/get-data-one")
	public ServiceData getDataOneService() {
		log.info("In the method of Controller");
		
		return serviceOneFeignClient.getDataOne();
	}
	
	
	@PostMapping(path = "/post-data-one")
	public ServiceData postDataServiceOne(@RequestBody ServiceData data) {
		return serviceOneFeignClient.postDataOne(data);
	}
	
	//Service Two methods
	
	@GetMapping(path = "/hello-two")
	public String sayHelloServiceTwo() {
		log.info("In the method of Controller");
		
		return serviceTwoFeignClient.sayHello();
	}

	@GetMapping(path = "/service-info-two")
	public String getServerOneInfo(HttpServletRequest request) {
		log.info("In the method of Controller");
		
		return serviceTwoFeignClient.getServerOneInfo(request);
	}

	@GetMapping(path = "/get-data-two")
	public ServiceData getDataServiceTwo() {
		log.info("In the method of Controller");
		
		return serviceTwoFeignClient.getDataOne();
	}

	@PostMapping(path = "/post-data-two")
	public ServiceData postDataOne(@RequestBody ServiceData data) {
		log.info("In the method of Controller");
		
		return serviceTwoFeignClient.postDataOne(data);
	}

	@GetMapping(path = "/welcome-message-two")
	public String welcomeMessage() {
		log.info("In the method of Controller");
		
		return serviceTwoFeignClient.welcomeMessage();
	}

	@GetMapping(path = "/hello-service-two")
	public String helloService() {
		log.info("In the method of Controller");
		
		return serviceTwoFeignClient.helloService();
	}

	@GetMapping(path = "/service-two-code")
	public String serviceTwoCode() {
		log.info("In the method of Controller");
		
		return serviceTwoFeignClient.serviceTwoCode();
	}
	
	//--calling service two then -> call service zero -
	
	@GetMapping(path="/get-data-zero")
	public ServiceData callZeroService(HttpServletRequest request) {
		log.info("In the method of Controller");
		
		return serviceTwoFeignClient.getDataZero(request);
	}

}
