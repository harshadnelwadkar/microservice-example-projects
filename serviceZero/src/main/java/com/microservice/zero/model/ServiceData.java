/**
 * 
 */
package com.microservice.zero.model;

/**
 * @author harshadnelwadkar
 *
 */
@lombok.Data
public class ServiceData {
	private String welcomeMessage;
	private String serviceName;
	
	
	public String getWelcomeMessage() {
		return welcomeMessage;
	}
	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	

}
