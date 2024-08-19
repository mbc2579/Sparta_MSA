package com.market.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {

    public void creatPayment(DeliveryMessage deliveryMessage) {
        Payment payment = Payment.builder().paymentId(UUID.randomUUID()).payAmount(deliveryMessage.getPayAmount()).userId(deliveryMessage.getUserId()).payStatus("SUCCESS").build();

        Integer payAmount = deliveryMessage.getPayAmount();

        if(payAmount >= 10000) {
            log.error("Payment amount exceeds limit : {}", payAmount);
        }
    }
}
