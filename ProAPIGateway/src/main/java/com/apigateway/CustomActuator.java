package com.apigateway;

import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class CustomActuator {

	@ReadOperation
	public Map<String, Object> getCustomAttributes() {
		return null;
	}
}
