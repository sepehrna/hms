package com.business.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RevolutOrderDto {
    private UUID id;
    @JsonProperty("public_id")
    private UUID publicId;
    private String type;
    private String state;
    @JsonProperty("created_at")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate createdAt;
    @JsonProperty("updated_at")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate updatedAt;

    @JsonProperty("completed_at")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate completedAt;
    @JsonProperty("capture_mode")
    private String captureMode;
    @JsonProperty("customer_id")
    private UUID customerId;
    private String email;
    @JsonProperty("order_amount")
    private AmountDto orderAmountDto;
    @JsonProperty("order_outstanding_amount")
    private AmountDto orderOutstandingAmountDto;
    @JsonProperty("refunded_amount")
    private AmountDto refundedAmount;
    private Map<String, Object> metadata;
    @JsonProperty("checkout_url")
    private String checkoutUrl;

    private List<PaymentDto> payments;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDate completedAt) {
        this.completedAt = completedAt;
    }

    public String getCaptureMode() {
        return captureMode;
    }

    public void setCaptureMode(String captureMode) {
        this.captureMode = captureMode;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AmountDto getOrderAmount() {
        return orderAmountDto;
    }

    public void setOrderAmount(AmountDto orderAmountDto) {
        this.orderAmountDto = orderAmountDto;
    }

    public AmountDto getOrderOutstandingAmount() {
        return orderOutstandingAmountDto;
    }

    public void setOrderOutstandingAmount(AmountDto orderOutstandingAmountDto) {
        this.orderOutstandingAmountDto = orderOutstandingAmountDto;
    }

    public AmountDto getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(AmountDto refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getCheckoutUrl() {
        return checkoutUrl;
    }

    public void setCheckoutUrl(String checkoutUrl) {
        this.checkoutUrl = checkoutUrl;
    }

    public AmountDto getOrderAmountDto() {
        return orderAmountDto;
    }

    public void setOrderAmountDto(AmountDto orderAmountDto) {
        this.orderAmountDto = orderAmountDto;
    }

    public AmountDto getOrderOutstandingAmountDto() {
        return orderOutstandingAmountDto;
    }

    public void setOrderOutstandingAmountDto(AmountDto orderOutstandingAmountDto) {
        this.orderOutstandingAmountDto = orderOutstandingAmountDto;
    }

    public List<PaymentDto> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentDto> payments) {
        this.payments = payments;
    }
}
