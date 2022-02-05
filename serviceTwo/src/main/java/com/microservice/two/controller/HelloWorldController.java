/**
 * 
 */
package com.microservice.two.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author harshadnelwadkar
 *
 */
@RestController
@RequestMapping("two")
public class HelloWorldController {
	
	@GetMapping(path = "/hello")
	public String sayHello() {
		
		return "!!!  Hello world from SERVICE TWO  !!!";
	}

	@GetMapping(path = "/service-info")
	public String getServerOneInfo(HttpServletRequest request) {
		
		String remoteUser = request.getRemoteHost();
		String contextPath = request.getContextPath();
		int port = request.getLocalPort();
		return "remoteUser: "+remoteUser+" | contextPath: "+contextPath+" | port: "+port;
	}
}
