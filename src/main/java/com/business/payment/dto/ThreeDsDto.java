package com.business.payment.dto;

public class ThreeDsDto {
    private String state;
    private int version;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
}
