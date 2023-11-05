package com.business.payment.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.time.LocalDate;

public interface PaymentServices {
    String createPaymentOrder(String customerId, Double price, LocalDate checkInDate, LocalDate checkOutDate) throws JSONException, JsonProcessingException;

    String getCheckoutUrl(String paymentOrderId) throws JsonProcessingException;

    String getPaymentOrderStatus(String paymentOrderId) throws JsonProcessingException;

    String cancelPaymentOrder(String paymentOrderId) throws JsonProcessingException;

}
