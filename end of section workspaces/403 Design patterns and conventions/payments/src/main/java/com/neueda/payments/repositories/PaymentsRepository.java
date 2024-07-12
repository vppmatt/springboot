package com.neueda.payments.repositories;

import com.neueda.payments.model.Payment;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface PaymentsRepository extends JpaRepository<Payment, Long> {

    List<Payment> findAllByCountry(String country);

    List<Payment> findAllByOrderId(String orderId);
}
