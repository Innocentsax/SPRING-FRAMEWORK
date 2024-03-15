package dev.InnocentUdo.service.impl;

import dev.InnocentUdo.DTO.response.PaymentResponse;
import dev.InnocentUdo.model.Order;
import dev.InnocentUdo.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentResponse createPaymentLink(Order order) {
        return null;
    }
}
