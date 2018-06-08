package com.mycompany.context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

public class HCApplicationEventListener implements ApplicationListener<ApplicationFailedEvent> {
	final Log LOG = LogFactory.getLog(HCApplicationEventListener.class);
	
	@Override
	public void onApplicationEvent(ApplicationFailedEvent event) {
		
    	try {
			Class<?> clazz = Class.forName("com.mycompany.profile.core.domain.HCCustomerImpl");
			LOG.info("com.mycompany.profile.core.domain.HCCustomerImpl: " + clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			LOG.info("com.mycompany.profile.core.domain.HCCustomerImpl: ClassNotFoundException");
		}
	}

}
