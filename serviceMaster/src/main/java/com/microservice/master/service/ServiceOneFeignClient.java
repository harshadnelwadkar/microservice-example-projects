/**
 * 
 */
package com.microservice.master.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.master.data.ServiceData;


/**
 * @author harshadnelwadkar
 *
 */
@FeignClient(value = "SERVICE-ONE")
@LoadBalancerClient(name = "SERVICE-ONE")
public interface ServiceOneFeignClient {

	@GetMapping(path = "/one/hello")
	public String sayHello();

	@GetMapping(path = "/one/service-info")
	public String getServerOneInfo(HttpServletRequest request);
	
	@GetMapping(path = "/one/hello-service")
	public String helloService();
	
	
	@GetMapping(path = "/one/service-one-code")
	public String serviceOneCode();
	
	@GetMapping(path = "/one/get-data")
	public ServiceData getDataOne();
	
	
	@PostMapping(path = "/one/post-data")
	public ServiceData postDataOne(@RequestBody ServiceData data);
	

}
