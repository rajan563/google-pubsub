package com.rajantech.camel.components;

import org.apache.camel.component.google.pubsub.GooglePubsubComponent;
import org.apache.camel.component.google.pubsub.GooglePubsubConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GooglePubSubConfiguration {
	
	@Value("${credentials.fileLocation}")
	private String fileLocation;
	
	
	public GooglePubsubComponent createComponent() {
        GooglePubsubComponent component = new GooglePubsubComponent();
        GooglePubsubConnectionFactory connectionFactory = createConnectionFactory();
        component.setConnectionFactory(connectionFactory);
        return component;
    }

    public GooglePubsubConnectionFactory createConnectionFactory() {
        GooglePubsubConnectionFactory connectionFactory = new GooglePubsubConnectionFactory();
        connectionFactory.setCredentialsFileLocation(fileLocation);
        return connectionFactory;
    }
	

}
