package com.neueda.payments.control;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public class HealthcheckController {

    @GetMapping("/health")
    public Map<String,String> healthcheck() {
        return Map.of("status", "OK");
    }
}
