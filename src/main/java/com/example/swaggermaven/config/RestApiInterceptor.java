package com.example.swaggermaven.config;

import com.example.batch.model.EmployeeRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;

public class RestApiInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        ContentCachingRequestWrapper cachingRequestWrapper = new ContentCachingRequestWrapper(request);
      //  cachingRequestWrapper.getReader().lines()

        String xmlPayload = cachingRequestWrapper.getReader().lines().reduce("", String::concat);
        System.out.println(xmlPayload);

        EmployeeRequest request1 = new EmployeeRequest();
        request1.setId(1);
        request1.setName("Hello");

        // Attach the parsed object to the request attributes
        request.setAttribute("employeeRequest", request1);

        return true;
    }
}
