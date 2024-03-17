package dev.InnocentUdo.service;

import com.stripe.exception.StripeException;
import dev.InnocentUdo.DTO.response.PaymentResponse;
import dev.InnocentUdo.model.Order;

public interface PaymentService {
    public PaymentResponse createPaymentLink(Order order) throws StripeException;
}
