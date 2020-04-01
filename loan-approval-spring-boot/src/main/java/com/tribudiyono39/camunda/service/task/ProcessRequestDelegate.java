package com.tribudiyono39.camunda.service.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ProcessRequestDelegate implements JavaDelegate {
	
	private final static Logger logger = LoggerFactory.getLogger(ProcessRequestDelegate.class);
	
	public void execute(DelegateExecution execution) throws Exception {
		
		try {
			
			final String uri = "http://127.0.0.1:8912/hello";
		    RestTemplate restTemplate = new RestTemplate();
		    ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		     
		    logger.info("Response : " + response);
		    
		} catch (Exception e) {
			logger.info("EXCEPTION WHEN HIT API : ", e);
		}
	    
		logger.info("Processing request by '" + execution.getVariable("customerId") + "'...");
	}
}
