package com.business.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PaymentDto {
    private String id;
    private String state;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    private String token;
    @JsonProperty("amount")
    private AmountDto amountDto;
    @JsonProperty("authorised_amount")
    private AmountDto authorisedAmountDto;
    @JsonProperty("settled_amount")
    private AmountDto settledAmountDto;
    @JsonProperty("payment_method")
    private PaymentMethodDto paymentMethodDto;
    @JsonProperty("risk_level")
    private String riskLevel;
    private List<FeeDto> fees;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AmountDto getAmountDto() {
        return amountDto;
    }

    public void setAmountDto(AmountDto amountDto) {
        this.amountDto = amountDto;
    }

    public AmountDto getAuthorisedAmountDto() {
        return authorisedAmountDto;
    }

    public void setAuthorisedAmountDto(AmountDto authorisedAmountDto) {
        this.authorisedAmountDto = authorisedAmountDto;
    }

    public AmountDto getSettledAmountDto() {
        return settledAmountDto;
    }

    public void setSettledAmountDto(AmountDto settledAmountDto) {
        this.settledAmountDto = settledAmountDto;
    }

    public PaymentMethodDto getPaymentMethodDto() {
        return paymentMethodDto;
    }

    public void setPaymentMethodDto(PaymentMethodDto paymentMethodDto) {
        this.paymentMethodDto = paymentMethodDto;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public List<FeeDto> getFees() {
        return fees;
    }

    public void setFees(List<FeeDto> fees) {
        this.fees = fees;
    }
}
