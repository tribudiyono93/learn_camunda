package com.tribudiyono39.charge.card.worker;

import java.util.logging.Logger;
import java.awt.Desktop;
import java.net.URI;

import org.camunda.bpm.client.ExternalTaskClient;

public class ChargeCardWorker {
	private final static Logger LOGGER = Logger.getLogger(ChargeCardWorker.class.getName());
	
	public static void main(String[] args) {
		ExternalTaskClient client = ExternalTaskClient.create()
				.baseUrl("http://127.0.0.1:8080/engine-rest")
				.asyncResponseTimeout(10000)
				.build();
		
		client.subscribe("charge-card")
		.lockDuration(1000)
		.handler((externalTask, externalTaskService) -> {
			String item = (String) externalTask.getVariable("item");
			Long amount = (Long) externalTask.getVariable("amount");
			
			LOGGER.info("Charging credit card with an amount of : " + amount + "'€ for the item '" + item + "'...");
			
			try {
				Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
			} catch (Exception e) {
				e.printStackTrace();
	        }

	        // Complete the task
	        externalTaskService.complete(externalTask);
	          
		}).open();
	}
}
