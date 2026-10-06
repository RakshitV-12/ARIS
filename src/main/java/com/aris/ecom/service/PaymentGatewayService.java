package com.aris.ecom.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service managing payment provider tokenization, merchant settlement, and currency conversion.
 */
@Service
public class PaymentGatewayService {

    public String authorizeTransaction(double amount, String currency) {
        return "TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
