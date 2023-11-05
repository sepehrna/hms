package com.business.payment.dto;

public class CardDto {
    private String card_brand;
    private String card_bin;
    private String funding;
    private String card_country;
    private String card_last_four;
    private String card_expiry;
    private String cardholder_name;
    private ChecksDto checks;

    public String getCard_brand() {
        return card_brand;
    }

    public void setCard_brand(String card_brand) {
        this.card_brand = card_brand;
    }

    public String getCard_bin() {
        return card_bin;
    }

    public void setCard_bin(String card_bin) {
        this.card_bin = card_bin;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getCard_country() {
        return card_country;
    }

    public void setCard_country(String card_country) {
        this.card_country = card_country;
    }

    public String getCard_last_four() {
        return card_last_four;
    }

    public void setCard_last_four(String card_last_four) {
        this.card_last_four = card_last_four;
    }

    public String getCard_expiry() {
        return card_expiry;
    }

    public void setCard_expiry(String card_expiry) {
        this.card_expiry = card_expiry;
    }

    public String getCardholder_name() {
        return cardholder_name;
    }

    public void setCardholder_name(String cardholder_name) {
        this.cardholder_name = cardholder_name;
    }

    public ChecksDto getChecks() {
        return checks;
    }

    public void setChecks(ChecksDto checks) {
        this.checks = checks;
    }
}
