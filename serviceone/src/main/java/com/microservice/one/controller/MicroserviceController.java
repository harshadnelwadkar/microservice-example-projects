/**
 * 
 */
package com.microservice.one.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.one.model.ServiceData;

import lombok.Data;

/**
 * @author harshadnelwadkar
 *
 */
@RestController
@RequestMapping("one")
public class MicroserviceController {

	@Value("${welcome.message}")
	private String configwelcomeMessage;
	
	@Value("${server.port}")
	private String servicePort;
	
	@GetMapping(path = "/get-data")
	public ServiceData getDataOne(HttpServletRequest request) {
		ServiceData data = new ServiceData();
		data.setServiceName("SERVICE-ONE");
		data.setWelcomeMessage(configwelcomeMessage);
		
		String remoteUser = request.getRemoteHost();
		String contextPath = request.getContextPath();
		int port = request.getLocalPort();
		data.setRemoteuser("remoteUser:"+remoteUser+" | contextPath:"+contextPath+" | port:"+port);
		
		data.setServicePortDetails("Port:"+servicePort+" Context Path:"+request.getContextPath());
		
		
		return data;
	}
	
	@PostMapping(path = "/post-data")
	public ServiceData postDataOne(@RequestBody ServiceData data) {
		
		return data;
	}
	
	
}
