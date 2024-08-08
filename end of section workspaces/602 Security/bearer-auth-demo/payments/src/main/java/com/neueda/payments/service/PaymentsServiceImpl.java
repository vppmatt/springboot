package com.neueda.payments.service;

import com.neueda.payments.exceptions.NoMatchingPaymentException;
import com.neueda.payments.model.Payment;
import com.neueda.payments.repositories.PaymentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    private PaymentsRepository paymentsRepository;

    public PaymentsServiceImpl(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentsRepository.findAll();
    }

    @Override
    public List<Payment> getAllByCountry(String country) {
        return paymentsRepository.findAllByCountry(country);
    }

    @Override
    public Payment getById(Long id) throws NoMatchingPaymentException {
        return paymentsRepository.findById(id).orElseThrow(() -> new NoMatchingPaymentException("No payment found with id " + id));
    }


    @Override
    public Payment save(Payment payment){
           return paymentsRepository.save(payment);
    }

    @Override
    public List<Payment> getAllByOrderId(String orderId) {
        return paymentsRepository.findAllByOrderId(orderId);
    }

    @Override
    public List<String> getCountries() {
        return paymentsRepository.findAll().stream().map(Payment::getCountry).distinct().sorted().toList();
    }
}
