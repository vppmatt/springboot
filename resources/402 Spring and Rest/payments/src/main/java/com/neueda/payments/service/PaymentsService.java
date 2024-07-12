package com.neueda.payments.service;

import com.neueda.payments.model.Payment;

import java.util.*;

public interface PaymentsService {

    List<Payment> getAllPayments();

    Payment save(Payment payment);

}
