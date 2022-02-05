/**
 * 
 */
package com.microservice.two.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author harshadnelwadkar
 *
 */
@FeignClient (value = "SERVICE-ZERO")
@LoadBalancerClient(name = "SERVICE-ZERO")
public interface ServiceZeroFeignClient {
	
	@GetMapping(path = "/hello")
	public String sayHello();

	@GetMapping(path = "/service-info")
	public String getServerOneInfo(HttpServletRequest request) ;
	
	@GetMapping(path = "/get-exception") 
	public String throwException();

}
