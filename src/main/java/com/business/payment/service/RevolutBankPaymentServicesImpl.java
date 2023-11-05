package com.business.payment.service;

import com.business.payment.domain.PaymentServices;
import com.business.payment.dto.RevolutOrderDto;
import com.business.payment.facade.RevolutFacade;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class RevolutBankPaymentServicesImpl implements PaymentServices {

    private final RevolutFacade revolutFacade;

    @Autowired
    public RevolutBankPaymentServicesImpl(RevolutFacade revolutFacade) {
        this.revolutFacade = revolutFacade;
    }

    @Override
    public String createPaymentOrder(String customerId, Double price, LocalDate checkInDate, LocalDate checkOutDate) throws JSONException, JsonProcessingException {
        Double totalPrice = calculateTotalPrice(price, checkInDate, checkOutDate);
        RevolutOrderDto paymentOrder = revolutFacade.createPaymentOrder(customerId, totalPrice, "GBP");
        return paymentOrder.getId().toString();
    }

    @Override
    public String getCheckoutUrl(String paymentOrderId) throws JsonProcessingException {
        RevolutOrderDto revolutOrderDto = revolutFacade.fetchPaymentOrder(paymentOrderId);
        return revolutOrderDto.getCheckoutUrl();
    }

    @Override
    public String getPaymentOrderStatus(String paymentOrderId) throws JsonProcessingException {
        RevolutOrderDto revolutOrderDto = revolutFacade.fetchPaymentOrder(paymentOrderId);
        return revolutOrderDto.getState();
    }

    @Override
    public String cancelPaymentOrder(String paymentOrderId) throws JsonProcessingException {
        RevolutOrderDto revolutOrderDto = revolutFacade.cancelPaymentOrder(paymentOrderId);
        return revolutOrderDto.getState();
    }

    private Double calculateTotalPrice(Double price, LocalDate checkInDate, LocalDate checkOutDate) {
        long between = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        return price * between * 100;
    }
}
