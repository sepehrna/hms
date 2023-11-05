package com.business.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChecksDto {

    @JsonProperty("three_ds")
    private ThreeDsDto threeDsDto;

    public ThreeDsDto getThreeDsDto() {
        return threeDsDto;
    }

    public void setThreeDsDto(ThreeDsDto threeDsDto) {
        this.threeDsDto = threeDsDto;
    }
}
