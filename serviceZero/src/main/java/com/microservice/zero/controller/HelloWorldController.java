/**
 * 
 */
package com.microservice.zero.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.ServiceTestException;

/**
 * @author harshadnelwadkar
 *
 */
@RestController
@RequestMapping("zero")
public class HelloWorldController {
	
	//private static Logger log = Logger.get
			
	
	@GetMapping(path = "/hello")
	public String sayHello() {
		
		return "Hello world from Service One !!!";
	}

	@GetMapping(path = "/service-info")
	public String getServerOneInfo(HttpServletRequest request) {
		
		String remoteUser = request.getRemoteHost();
		String contextPath = request.getContextPath();
		int port = request.getLocalPort();
		return "remoteUser:"+remoteUser+" | contextPath:"+contextPath+" | port:"+port;
	}
	
	@GetMapping(path = "/get-exception")
	public String throwException() {
		throw new ServiceTestException("!!!  Exception from service zero !!!");
	}
}
