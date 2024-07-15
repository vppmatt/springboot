package com.neueda.payments.control;

import com.neueda.payments.service.PaymentsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/country")
@CrossOrigin
public class CountryController {

    private PaymentsService paymentsService;

    public CountryController(PaymentsService userService) {
        this.paymentsService = userService;
    }

    @GetMapping
    public List<String> getCountries() {
        return paymentsService.getCountries();
    }
}
