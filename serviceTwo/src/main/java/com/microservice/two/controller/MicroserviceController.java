/**
 * 
 */
package com.microservice.two.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.two.model.ServiceData;
import com.microservice.two.service.ServiceZeroFeignClient;

/**
 * @author harshadnelwadkar
 *
 */
@RestController
@RequestMapping("two")
public class MicroserviceController {

	@Value("${welcome.message}")
	private String configwelcomeMessage;
	
	@Value("${server.port}")
	private String servicePort;
	
	@Autowired
	private ServiceZeroFeignClient serviceZeroFeignClient;
	
	
	@GetMapping(path = "/get-data")
	public ServiceData getDataOne(HttpServletRequest request) {
		ServiceData data = new ServiceData();
		data.setServiceName("SERVICE-TWO");
		data.setWelcomeMessage(configwelcomeMessage);
		
		String remoteUser = request.getRemoteHost();
		String contextPath = request.getContextPath();
		int port = request.getLocalPort();
		data.setRemoteuser("remoteUser:"+remoteUser+" | contextPath:"+contextPath+" | port:"+port);
		
		data.setServicePortDetails("Port:"+servicePort+" Context Path:"+request.getContextPath());
		
		
		return data;
	}
	
	@GetMapping(path = "/get-data-zero")
	public ServiceData getDataZero(HttpServletRequest request) {
		ServiceData data = new ServiceData();
		data.setServiceName("SERVICE-TWO");
		try 
		{
			serviceZeroFeignClient.throwException();
			
		} catch (Exception e) {
			data.setWelcomeMessage(e.getMessage());
		}
			
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
