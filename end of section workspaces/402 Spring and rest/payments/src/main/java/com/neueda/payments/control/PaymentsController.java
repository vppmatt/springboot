package com.neueda.payments.control;

import com.neueda.payments.exceptions.NoMatchingPaymentException;
import com.neueda.payments.model.Payment;
import com.neueda.payments.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class PaymentsController {

    private PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentService) {
        this.paymentsService = paymentService;
    }

    @GetMapping(produces={MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    public List<Payment> getPayments(@RequestParam(value="country", required = false) String country, @RequestParam(value="orderId", required = false) String OrderId) {
        if (country != null) {
            return paymentsService.getAllByCountry(country);
        }
        if (OrderId != null) {
            return paymentsService.getAllByOrderId(OrderId);
        }
        return paymentsService.getAllPayments();
    }


    @GetMapping(value="/{id}", produces={MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    public Payment getPaymentById(@PathVariable("id") Long id) throws NoMatchingPaymentException {
        return paymentsService.getById(id);
    }

    @PostMapping
    public Payment savePayment(@RequestBody Payment payment) {
        return paymentsService.save(payment);
    }

}
