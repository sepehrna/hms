package com.business.payment.controller;

import com.business.payment.domain.PaymentServices;
import com.business.payment.dto.PayRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicReference;

@Validated
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    private final PaymentServices paymentServices;

    @Autowired
    public PaymentController(PaymentServices paymentServices) {
        this.paymentServices = paymentServices;
    }

    @PostMapping(value = "/payment-order", consumes = MediaType.ALL_VALUE)
    ResponseEntity<String> createPaymentOrder(@Valid @RequestBody PayRequestDto requestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            AtomicReference<String> errors = new AtomicReference<>("");
            bindingResult.getAllErrors()
                    .forEach(objectError -> errors.set("\n".concat(errors.get().concat(objectError.toString()))));
            return ResponseEntity.badRequest().body(errors.get());
        }
        String paymentOrderId;
        try {
            paymentOrderId = paymentServices.createPaymentOrder(
                    requestDto.getCustomerId()
                    , requestDto.getAmount()
                    , requestDto.getCheckInDate()
                    , requestDto.getCheckOutDate()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(paymentOrderId);
    }

    @GetMapping(value = "/checkout-url/{paymentOrderId}")
    ResponseEntity<String> getCheckoutUrl(@PathVariable String paymentOrderId) {
        String checkoutUrl;
        try {
            checkoutUrl = paymentServices.getCheckoutUrl(paymentOrderId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(checkoutUrl);
    }

    @GetMapping(value = "/status/{paymentOrderId}")
    ResponseEntity<String> getPaymentStatus(@PathVariable String paymentOrderId) {
        String paymentStatus;
        try {
            paymentStatus = paymentServices.getPaymentOrderStatus(paymentOrderId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(paymentStatus);
    }

    @PutMapping(value = "/cancel/{paymentOrderId}")
    ResponseEntity<String> cancelPayment(@PathVariable String paymentOrderId) {
        String paymentStatus;
        try {
            paymentStatus = paymentServices.cancelPaymentOrder(paymentOrderId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(paymentStatus);
    }

}
