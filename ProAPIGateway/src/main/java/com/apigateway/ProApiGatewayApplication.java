package com.apigateway;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ProApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProApiGatewayApplication.class, args);
	}

	@Bean
	public HttpTraceRepository getHttpTraceRepository() {
		return new HttpTraceRepository() {
		    AtomicReference<HttpTrace> lastTrace = new AtomicReference<>();
		    List<HttpTrace> listTrace = new ArrayList<HttpTrace>();
			@Override
			public List<HttpTrace> findAll() {
				return listTrace;
			}
			
			@Override
			public void add(HttpTrace trace) {
		        if (!trace.getRequest().getUri().getRawPath().contains("actuator")) {
		        	listTrace.add(trace);
		        }
			}
		};
	}
}
