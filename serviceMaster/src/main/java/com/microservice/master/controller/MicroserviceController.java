/**
 * 
 */
package com.microservice.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.master.data.ServiceData;

/**
 * @author harshadnelwadkar
 *
 */
@RestController
@RequestMapping("rest")
public class MicroserviceController {

	@Value("${welcome.message}")
	private String configwelcomeMessage;

	@Value("${service.one.url}")
	private String serviceOneUrl;

	@Value("${service.one.url}")
	private String serviceTwoUrl;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(path = "/service-one-data")
	public ServiceData getDataFromServiceOne() {
		ServiceData data = new ServiceData();
		data.setServiceName("service-one");
		data.setWelcomeMessage(configwelcomeMessage);

		return data;
	}

	@GetMapping(path = "/service-two-data")
	public ServiceData getDataFromServiceTwo() {
		ServiceData data = new ServiceData();
		data.setServiceName("service-two");
		data.setWelcomeMessage(configwelcomeMessage);

		return data;
	}

	@PostMapping(path = "/service-one-post")
	public ServiceData postDataOne(@RequestBody ServiceData data) {

		return data;
	}

	// ------ HelloWrold calls ---------
	@GetMapping(path = "/hello-one")
	public String geServiceOneHello() {

		return restTemplate.getForObject(serviceOneUrl + "/hello", String.class);
	}

	@GetMapping(path = "/hello-two")
	public String getServiceTwoHello() {

		return restTemplate.getForObject(serviceTwoUrl + "/hello", String.class);
	}

	@GetMapping(path = "/service-info-one")
	public String getServerOneInfo() {

		return restTemplate.getForObject(serviceOneUrl + "/service-info", String.class);
	}

	@GetMapping(path = "/service-info-two")
	public String getServerTwoInfo() {

		return restTemplate.getForObject(serviceTwoUrl + "/service-info", String.class);
	}

	
	
}
