package com.rajantech.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CamelGooglePubsubRouteBuilder extends RouteBuilder{
	
	
	@Value("${pubsub.topicEndpoint}")
	private String topicEndpoint;
	
	@Value("${pubsub.subEndpoint}")
	private String subEndpoint;
	
	
	@Override
	public void configure() throws Exception {
		
		
		from("timer://foo?period=5s")
		.log("working")
		.setBody().simple("Hi from Rajan ${date:now:yyyy-MM-dd yyyy-MM-dd}")
		.to(topicEndpoint)
		.log(" message successfully send to google pubsub ${body} ::::: ${in.headers}");
		
	}

}
