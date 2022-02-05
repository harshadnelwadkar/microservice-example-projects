/**
 * 
 */
package com.microservice.two.model;

import java.io.Serializable;

/**
 * @author harshadnelwadkar
 *
 */
@lombok.Data
public class ServiceData implements Serializable {
	private String welcomeMessage;
	private String serviceName;
	private String servicePortDetails;
	private String remoteuser;
	
	
	
	public String getServicePortDetails() {
		return servicePortDetails;
	}
	public void setServicePortDetails(String servicePortDetails) {
		this.servicePortDetails = servicePortDetails;
	}
	public String getRemoteuser() {
		return remoteuser;
	}
	public void setRemoteuser(String remoteuser) {
		this.remoteuser = remoteuser;
	}
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
