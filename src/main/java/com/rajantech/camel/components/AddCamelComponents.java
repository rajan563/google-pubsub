package com.rajantech.camel.components;

import org.apache.camel.CamelContext;
import org.apache.camel.component.google.pubsub.GooglePubsubComponent;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AddCamelComponents {
	
	 private static final String google_pubsub = "google-pubsub";
	 
	 @Autowired
	 public GooglePubSubConfiguration googlepubsub;
	
	@Bean
    CamelContextConfiguration contextConfiguration() {
        	return new CamelContextConfiguration() {
				@Override
				public void beforeApplicationStart(CamelContext context) {
					GooglePubsubComponent google = googlepubsub.createComponent();
	                 context.addComponent(google_pubsub, google);
				}
				
				@Override
				public void afterApplicationStart(CamelContext arg0) {
					// TODO Auto-generated method stub
					
				}
			};
        }

}
