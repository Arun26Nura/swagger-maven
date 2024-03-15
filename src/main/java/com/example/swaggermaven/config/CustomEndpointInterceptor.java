package com.example.swaggermaven.config;

import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.MessageEndpoint;
import org.springframework.ws.context.MessageContext;
import org.springframework.stereotype.Component;

@Component
public class CustomEndpointInterceptor implements EndpointInterceptor {

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        System.out.println("Handling request in interceptor");
        // Implement your interceptor logic for handling the request
        return true; // Return true to continue processing the request
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        System.out.println("Handling response in interceptor");
        // Implement your interceptor logic for handling the response
        return true; // Return true to continue processing the response
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        System.out.println("Handling fault in interceptor");
        // Implement your interceptor logic for handling faults
        return true; // Return true to continue processing the fault
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        // Perform any cleanup tasks after the request has been processed
    }
}
