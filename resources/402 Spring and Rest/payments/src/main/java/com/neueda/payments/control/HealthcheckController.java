package com.neueda.payments.control;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
THIS IS THE RESOURCES PROJECT _ SET UP DATA!
 */

@RestController
@CrossOrigin
public class HealthcheckController {

    @GetMapping("/health")
    public String healthcheck() {
        return "OK";
    }
}
