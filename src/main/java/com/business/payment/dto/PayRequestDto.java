package com.business.payment.dto;

import com.business.payment.annotations.ValidDateRange;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@ValidDateRange
public class PayRequestDto {

    @NotNull
    private String customerId;
    @NotNull
    @Min(1)
    private Double amount;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @JsonIgnore
    private RevolutOrderDto orderDto;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public RevolutOrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(RevolutOrderDto orderDto) {
        this.orderDto = orderDto;
    }
}
