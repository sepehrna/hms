package com.business.payment.facade;

import com.business.payment.dto.RevolutOrderDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class RevolutFacade {


    @Value("${services.bank.url}")
    private String baseUrl;

    @Value("${services.bank.apiKey}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public RevolutOrderDto createPaymentOrder(String customerId, Double amount, String currency) throws JSONException, JsonProcessingException {

        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + apiKey);


        // Preparing main request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("amount", amount);
        requestBody.put("currency", currency);
        requestBody.put("metadata ", "{\r\n \"metadata\": {\r\n    \"customer_id\": \"" + customerId + "\"\r\n  }\r\n}");

        HttpEntity<String> request = new HttpEntity<>(requestBody.toString(), headers);

        // Execute the HTTP Request
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl + "/orders", request, String.class);

        // Extract response body
        String responseBody = response.getBody();

        return new ObjectMapper().readValue(responseBody, RevolutOrderDto.class);
    }

    public RevolutOrderDto fetchPaymentOrder(String paymentOrderId) throws JsonProcessingException {

        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<String> request = new HttpEntity<>(headers);

        // Execute the HTTP Request
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/orders/" + paymentOrderId, HttpMethod.GET, request, String.class);

        // Extract response body
        String responseBody = response.getBody();

        return new ObjectMapper().readValue(responseBody, RevolutOrderDto.class);
    }

    public RevolutOrderDto cancelPaymentOrder(String paymentOrderId) throws JsonProcessingException {

        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + apiKey);


        HttpEntity<String> request = new HttpEntity<>(headers);

        // Execute the HTTP Request
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl + "/orders" + "/" + paymentOrderId + "/cancel", request, String.class);

        // Extract response body
        String responseBody = response.getBody();

        return new ObjectMapper().readValue(responseBody, RevolutOrderDto.class);
    }

}


