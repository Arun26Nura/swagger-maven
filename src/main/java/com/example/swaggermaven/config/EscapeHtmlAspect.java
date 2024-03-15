package com.example.swaggermaven.config;


import com.example.batch.model.EmployeeRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

@RestControllerAdvice
public class EscapeHtmlAspect implements RequestBodyAdvice , ResponseBodyAdvice {
    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage,
                                           MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        InputStream inputStream = inputMessage.getBody();
        return new HttpInputMessage() {
            @Override
            public InputStream getBody() throws IOException {

                String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
                System.out.println(result);

                EmployeeRequest request= new EmployeeRequest();
                request.setId(3);
                request.setName("Test Arun");
                ObjectWriter ow = new ObjectMapper().writer();
                String json = ow.writeValueAsString(request);
                System.out.println(inputStream);
                return new ByteArrayInputStream(json.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                return inputMessage.getHeaders();
            }
        };
    }

    @Override
    public boolean supports(MethodParameter methodParameter,
                            Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage,
                                MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage,
                                  MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        System.out.println("Hello");
        return 1;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {

        return true;
    }
}