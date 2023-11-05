package com.business.payment.validators;

import com.business.payment.annotations.ValidDateRange;
import com.business.payment.dto.PayRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidDateRange, PayRequestDto> {

    @Override
    public boolean isValid(PayRequestDto dto, ConstraintValidatorContext context) {
        if (dto.getCheckInDate() == null || dto.getCheckOutDate() == null) {
            return false;
        }
        return !dto.getCheckOutDate().isBefore(dto.getCheckInDate());
    }
}
