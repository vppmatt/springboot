package com.neueda.payments.service;

import com.neueda.payments.exceptions.NoMatchingPaymentException;
import com.neueda.payments.model.Payment;

import java.util.*;

public interface PaymentsService {

    List<Payment> getAllPayments();

    List<Payment> getAllByCountry(String country);

    Payment getById(Long id) throws NoMatchingPaymentException;

    Payment save(Payment payment);

    List<Payment> getAllByOrderId(String orderId);

    List<String> getCountries();
}
